# Why?

This module is for me to remember how to build, package and run with sbt;

# What?

## Build

```
sbt clean compile package
```

The artefact should be produced in balionis-scala\balionis-scala4\target\scala-2.11\balionis-scala4_2.11-1.0.jar

## Run

```
sbt "run myarg1 myarg2"
```
or
```
sbt "runMain com.balionis.scala4.MyApp myarg1 myarg2"
```

If all goes as expected you should see output like
```
[info] Running com.balionis.scala4.MyApp myarg1 myarg2
20:26:39.554 TKD [run-main-0] DEBUG com.balionis.scala4.MyApp$ - MyApp: args=myarg1, myarg2
20:26:39.554 TKD [run-main-0] DEBUG com.balionis.scala4.MyService$ - newService: name=myarg1
20:26:39.554 TKD [run-main-0] DEBUG com.balionis.scala4.MyApp - echo: msg=myarg2
20:26:39.554 TKD [run-main-0] DEBUG com.balionis.scala4.MyService - echo: name=[myarg1, myarg2], msg={}
20:26:39.570 TKD [run-main-0] DEBUG com.balionis.scala4.MyApp$ - MyApp: app=myarg1:myarg2
res=myarg1:myarg2
[success] Total time: 1 s, completed 12-Apr-2018 20:26:39
```