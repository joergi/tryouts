# Tryout for Apache Beam Dependency problem

somehow you get on the Mac different versions, then on Linux
see: [available-on-linux.txt](available-on-linux.txt) vs [available-on-mac.txt](available-on-mac.txt)

Java Version: `21.0.1-librca`

to reproduce:
```bash
cd apache-beam-dependency-problem
./gradlew clean installDist
ls -lah build/install/apache-beam-dependency-problem/lib/ > output.txt 
```

open the file output.txt and see if the following dependencies are there:
```
beam-runners-direct-java-2.53.0.jar
beam-sdks-java-core-2.53.0.jar
beam-sdks-java-harness-2.53.0.jar
beam-sdks-java-transform-service-launcher-2.53.0.jar
beam-vendor-grpc-1_54_0-0.1.jar
beam-vendor-guava-32_1_2-jre-0.1.jar
```