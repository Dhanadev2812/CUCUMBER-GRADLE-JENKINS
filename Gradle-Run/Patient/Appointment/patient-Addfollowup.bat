set projectLocation=D:\Testing workspace\ClinaNG
set tagName=@Patient:Addfollowup
d:
cd %projectLocation%
cmd /k gradle cucumber -Dcucumber.options="--tags %tagName%"
pause
