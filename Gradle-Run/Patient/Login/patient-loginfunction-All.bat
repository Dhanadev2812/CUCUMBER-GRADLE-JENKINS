set projectLocation=D:\Testing workspace\ClinaNG
set tagName=@patient:loginfunction
d:
cd %projectLocation%
cmd /k gradle cucumber -Dcucumber.options="--tags %tagName%"
pause
