set projectLocation=D:\Testing workspace\ClinaNG
set tagName01=@Downloadall-Medicalreport
set tagName02=@patient
d:
cd %projectLocation%
cmd /k gradle cucumber -Dcucumber.options="--tags %tagName01% and --tags %tagName02%%"
pause
