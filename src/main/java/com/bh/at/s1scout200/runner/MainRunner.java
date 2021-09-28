/****************************************************************************************************************
 * BH Confidential                                                                                              *
 * Unpublished Copyright 2021.  Baker Hughes Company                                                            *
 *                                                                                                              *
 * NOTICE:  All information contained herein is, and remains the property of  Baker Hughes Company,  and/or its *
 * affiliates. The intellectual and technical concepts contained herein are proprietary to Baker Hughes Company *
 * and/or its affiliates and may be covered by  patents,  copyrights,  and/or trade secrets.   Dissemination of *
 * this information or reproduction of this material is  strictly forbidden unless prior  written permission is *
 * obtained from Baker Hughes Company.                                                                          *
 ***************************************************************************************************************/

   /* ** AUTOGENERATED - DO NOT MODIFY, ANY MODIFICATIONS WILL BE OVERWRITTEN!!!!! ** */

package com.bh.at.s1scout200.runner;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.cucumber.core.cli.Main;
import io.cucumber.junit.Cucumber;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bh.constutil.OptArgs;
import static com.bh.constutil.Const.*;

/**
 * The main class.
 */
@RunWith(Cucumber.class)
public final class MainRunner {
  private static final Logger LOG = setupLogConf();
  private static final String DEF_LOG_CONF = "log.conf";

  private static String envParamsFile;
  private static String suites;
  private static String reportsFolder;
  private static final String[] runtime = new String[RT_NUM_PARTS];

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {

    LOG.info("MainRunner Started");

    HandleArgs(args);

    AppConfig.loadEnv(envParamsFile);

    AppConfig.setRuntimeParameters(runtime);

    AppConfig.initUiDrivers();

    AppConfig.loadEnvParams();

    Main.main(AppConfig.getCucumberRunTimeParam("s1scout200", suites, reportsFolder));

  }

  /**
   * Set the log configuration for tinylog
   *
   */
  private static Logger setupLogConf() {

    String logConfiguration = "s1scout200";
    if (null == System.getProperty("tinylog.configuration")) {
      String jarName = new java.io.File(MainRunner.class.getProtectionDomain().getCodeSource().getLocation().getPath())
          .getName();
      // jarname will not work when running from the ide works only on command line
      if (jarName.endsWith(".jar")) {
        Matcher m = Pattern.compile("(.+)(-\\d+\\..+\\.jar)").matcher(jarName);
        if (m.find()) {
          logConfiguration = m.group(1);
        }
      }

      logConfiguration += "." + DEF_LOG_CONF;

      if (Files.exists(Path.of(logConfiguration))) {
        System.setProperty("tinylog.configuration", logConfiguration);
      } else if (Files.exists(Path.of(DEF_LOG_CONF))) {
        System.setProperty("tinylog.configuration", DEF_LOG_CONF);
      }
    }

    return LoggerFactory.getLogger(MainRunner.class);
  }

  /**
   * Handle args.
   *
   * @param args the args
   */
  private static void HandleArgs(String[] args) {

    Map<String, String> optionsArgs = new HashMap<>();
    List<String> cmdArgs = new ArrayList<>();

    OptArgs.processArgs(args, optionsArgs, cmdArgs);

    if (cmdArgs.size() > 1) {
      AppConfig.AppErrorExit(new Exception("Exactly ZERO or ONE argument expected"));
    } else {
      envParamsFile = (0 == cmdArgs.size()) ? "envParams.json" : cmdArgs.get(0);
    }

    optionsArgs.forEach((String key, String value) -> {
//      System.out.println(key + " -> " + value);

      switch (key) {
        case "suites":
          suites = value;
          break;

        case "browser":
          runtime[BROWSERS_OR_APPS_NDX] = value;
          break;

        case "device":
          runtime[DEVICE_NDX] = value;
          break;

        case "platform":
          runtime[PLATFORM_NDX] = value;
          break;

        case "report":
          reportsFolder = value;
          break;

        case "env":
          envParamsFile = value;
          break;

        default:
          System.out.println("Unknown option " + key);
          printUsageAndExit();
          break;
      }
    });

    envParamsFile = envParamsFile.trim();

    if (0 == envParamsFile.length()) {
      LOG.error("Argument cannot be an empty string");
      printUsageAndExit();
    }
  }

  /**
   * Print usage and exit.
   */
  private static void printUsageAndExit() {
    System.out.println("Usage: java -jar <jarName> --env=<environment parameters file> --suites=<suite tags for cucumber> --browser=<browse to start> --report=<target folder name for the generated cucumber.json , xml and html files>");
    System.out.println("\tAll arguments are optional, defaults are as follows");
    System.out.println("\tenvParams.json default for --env");
    System.out.println("\tAll features default for --suites");
    System.out.println("\tvalue from env params is the default for --browser");
    System.out.println("\trelative to current folder is the default for --report");

    System.exit(1);
  }
}

/*
https://cucumber.io/docs/cucumber/api/
Tag expressions
A tag expression is an infix boolean expression. Below are some examples:

Expression	          Description
@fast	              Scenarios tagged with @fast
@wip and not @slow	  Scenarios tagged with @wip that aren’t also tagged with @slow
@smoke and @fast	  Scenarios tagged with both @smoke and @fast
@gui or @database	  Scenarios tagged with either @gui or @database

For even more advanced tag expressions you can use parenthesis for clarity, or to change operator precedence:
(@smoke or @ui) and (not @slow)

*/