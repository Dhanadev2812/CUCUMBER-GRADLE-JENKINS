set projectLocation=D:\Testing workspace\ClinaNG
set tagName=@patient:login_invalid_clinic_code
d:
cd %projectLocation%
cmd /k gradle cucumber -Dcucumber.options="--tags %tagName%"
pause
