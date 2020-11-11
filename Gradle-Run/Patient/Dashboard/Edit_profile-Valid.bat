set projectLocation=D:\Testing workspace\ClinaNG
set tagName01=@Editprofile-valid
set tagName02=@patient
d:
cd %projectLocation%
cmd /k gradle cucumber -Dcucumber.options="--tags %tagName01% and --tags %tagName02%"
pause
