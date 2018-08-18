# Why?

This simplation is to prove the ball machine randomizer is broken.

# What?

## Build

```
gradle clean build
```

_Note: Text_

## Install

```
gradle install
```

_Note: Text_

## Run

```
gradle run -Dmyvariable=myvalue -Dexec.args="draw-history.csv ball draw-ball.csv"
```

_Note: if all goes well then output should look like_

```
>gradle run -Dmyvariable=myvalue -Dexec.args="draw-history.csv ball draw-ball.csv"
:compileJava UP-TO-DATE
:compileScala UP-TO-DATE
:processResources UP-TO-DATE
:classes UP-TO-DATE
:run
...
BUILD SUCCESSFUL

Total time: 2.225 secs
```