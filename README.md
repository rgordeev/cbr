## How to run application?

1. Install sdkman http://sdkman.io by running `curl -s get.sdkman.io | bash` in your terminal [optional]
2. Install gradle via running `sdk i gradle 2.9` or by downloading it from http://gradle.org/gradle-download/
3. Clone this repository by `git clone https://github.com/rgordeev/cbr.git`
4. Change current folder to project root by `cd cbr`
5. Run `gradle build`
6. Import project from your IDE, e.g. IntelliJ IDEA
7. Run Launcher class in your IDE or you may run `gradle fatJar` and then run `java -jar build/libs/cbr-all-1.0.jar` from the root folder

## Generate Client Classes by WSDL

wsimport -d src/main/java/ -p cbr.client -b http://www.w3.org/2001/XMLSchema.xsd  -b customization.xjb -Xnocompile http://www.cbr.ru/DailyInfoWebServ/DailyInfo.asmx?WSDL
