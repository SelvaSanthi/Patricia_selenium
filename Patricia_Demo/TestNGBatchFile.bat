set projectLocation=C:\Users\selvamuthukumar.g.ZUCISYSTEMS\OneDrive - zucisystems.com\SG\Patricia\Automation Files\Patricia_Demo
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\testng.xml
pause