# Why?

Lets build a prototype of scala standalone app with gradle build, package, test and dist.

# What?

## Build

```
gradle clean build
```

_Note: if you did not touch balionis-scala3\gradle.properties then the artifact should be at balionis-scala3\build\libs\balionis-scala3-1.0-SNAPSHOT.jar_

## Install

```
gradle install
```

_Note: if you did not touch balionis-scala3\gradle.properties then the artifact should be at C:\share\repository\com\balionis\balionis-scala3\1.0-SNAPSHOT_

## Run

```
gradle run -Dmyvariable=myvalue -Dexec.args="myarg1 myarg2"
```

_Note: if all goes well then output should look like_

```
>gradle run -Dmyvariable=myvalue -Dexec.args="myarg1 myarg2"
:compileJava UP-TO-DATE
:compileScala UP-TO-DATE
:processResources UP-TO-DATE
:classes UP-TO-DATE
:run
20:19:17.248 TKD [main] DEBUG com.balionis.scala3.MyApp$ - MyApp: args=myarg1, myarg2
20:19:17.253 TKD [main] DEBUG com.balionis.scala3.MyService$ - newService: name=myarg1
20:19:17.253 TKD [main] DEBUG com.balionis.scala3.MyApp - echo: msg=myarg2
20:19:17.254 TKD [main] DEBUG com.balionis.scala3.MyService - echo: name=[myarg1, myarg2], msg={}
20:19:17.255 TKD [main] DEBUG com.balionis.scala3.MyApp$ - MyApp: app=myarg1:myarg2
res=myarg1:myarg2

BUILD SUCCESSFUL

Total time: 2.225 secs
```