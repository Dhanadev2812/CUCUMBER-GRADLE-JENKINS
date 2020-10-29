set projectLocation=D:\Testing workspace\ClinaNG
set tagName01=@patient:Appointment
set tagName02=@patient-smokeTest
d:
cd %projectLocation%
//cmd /k gradle cucumber -Dcucumber.options="--tags %tagName01%,%tagName02%"
cmd /k gradle cucumber -Dcucumber.options="--tags %tagName01%"
pause
