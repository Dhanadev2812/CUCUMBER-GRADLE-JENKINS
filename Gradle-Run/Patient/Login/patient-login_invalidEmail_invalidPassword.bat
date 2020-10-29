set projectLocation=D:\Testing workspace\ClinaNG
set tagName=@patient:login_invalidEmail_invalidPassword
d:
cd %projectLocation%
cmd /k gradle cucumber -Dcucumber.options="--tags %tagName%"
pause
