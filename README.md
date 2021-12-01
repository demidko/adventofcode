# Advent of Code 2021

Here you can see the [code](./src/main/kotlin/com/adventofcode/2021/) for solving Advent of Code
2021 [problems](https://adventofcode.com/2021/). The solutions use a functional architecture.

## Build with Java

Execute `./gradlew clean build`. Your jar will be located at `./build/libs` with `-all.jar` postfix.
Now you can run:

```shell
java -jar advent-of-code-all.jar
```

## Or, build with Docker

Execute `docker build . -t advent-of-code`. Your image will be located at `docker images -a`. Now
you can run:

```shell
docker run -v `pwd`:`pwd` -w `pwd` -it --rm advent-of-code
```