
set MAVEN_HOME=C:\Users\3691713\Documents\apache-maven-3.6.0
set PATH=%MAVEN_HOME%\bin;%PATH%

set projectLocation=C:\Users\3691713\git\RestAssured\NewRestAssured

cd %projectLocation%

mvn clean test -DsuiteXmlFile=testng.xml