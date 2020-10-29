set projectLocation=D:\Testing workspace\ClinaNG
set tagName=@Downloadall-Medicalreport
d:
cd %projectLocation%
cmd /k gradle cucumber -Dcucumber.options="--tags %tagName%"
pause
