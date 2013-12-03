Simple Akka test app using SBT
==============================

Running via SBT
---------------

This provides a fully running Akka sample. You can run it via sbt with the following command:

    sbt run

The sample is correctly configured to use AkkaLogging. While running, there will be some log messages on stdout.

The sample also includes a test class, which can be invoked as follows:

    sbt test

Running in IntelliJ IDEA
------------------------

This sample can also be run in IntelliJ IDEA (tested version 12). Use SBT to generate the necessary project files:

    sbt gen-idea

Afterwards, open the project in IntelliJ IDEA, right click on AkkaSbt.scala in project tree and select run from
context menu.

To execute the test case, locate AkkaSbtTest.scala in project tree and select run from context menu.

Credits
-------

The code is based on the samples provided by [Roland Kuhn](https://twitter.com/rolandkuhn) in the reactive programming
course on Coursera.
