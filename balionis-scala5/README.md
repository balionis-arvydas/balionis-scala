# Why?

Lets build a prototype of scala standalone app with gradle build, package, test and dist.
Lets use guice injection.
Lets use arg4j command line parsing.

# What?

## Build

```
gradle clean build
```

_Note: if you did not touch balionis-scala5\gradle.properties then the artifact should be at balionis-scala3\build\libs\balionis-scala5-1.0-SNAPSHOT.jar_

## Install

```
gradle install
```

_Note: if you did not touch balionis-scala5\gradle.properties then the artifact should be at C:\share\repository\com\balionis\balionis-scala5\1.0-SNAPSHOT_

## Run

```
gradle run -Dmyvariable=myvalue -Dexec.args="-name myarg1 -msg myarg2"
```

_Note: if all goes well then output should look like_

```
>gradle run -Dmyvariable=myvalue -Dexec.args="-name myarg1 -msg myarg2"
:compileJava UP-TO-DATE
:compileScala UP-TO-DATE
:processResources UP-TO-DATE
:classes UP-TO-DATE
:run
10:45:34.246 TKD [main] DEBUG com.balionis.scala5.MyApp$ - MyApp: args=-name, myarg1, -msg, myarg2
10:45:34.320 TKD [main] DEBUG com.balionis.scala5.MyApp$ - MyApp: parsedArgs=name=myarg1, msg=myarg2
10:45:34.990 TKD [main] DEBUG com.balionis.scala5.MyAppRunnerImpl - run: args=name=myarg1, msg=myarg2
10:45:35.006 TKD [main] DEBUG com.balionis.scala5.MyServiceImpl - echo: name=myarg1, msg=myarg2
10:45:35.006 TKD [main] DEBUG com.balionis.scala5.MyAppRunnerImpl - run: res=myarg1:myarg2
10:45:35.006 TKD [main] DEBUG com.balionis.scala5.MyApp$ - MyApp: done

BUILD SUCCESSFUL

Total time: 3.32 secs
```