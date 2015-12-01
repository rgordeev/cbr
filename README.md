## Generate Client Classes by WSDL

wsimport -d src/main/java/ -p cbr.client -b http://www.w3.org/2001/XMLSchema.xsd  -b customization.xjb -Xnocompile http://www.cbr.ru/DailyInfoWebServ/DailyInfo.asmx?WSDL
