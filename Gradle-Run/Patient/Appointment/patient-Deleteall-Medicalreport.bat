set projectLocation=D:\Testing workspace\ClinaNG
set tagName=@Deleteall-Medicalreport
d:
cd %projectLocation%
cmd /k gradle cucumber -Dcucumber.options="--tags %tagName%"
pause
