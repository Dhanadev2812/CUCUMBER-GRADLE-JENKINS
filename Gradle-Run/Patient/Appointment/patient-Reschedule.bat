set projectLocation=D:\Testing workspace\ClinaNG
set tagName=@Patient:Reschedule
d:
cd %projectLocation%
cmd /k gradle cucumber -Dcucumber.options="--tags %tagName%"
pause
