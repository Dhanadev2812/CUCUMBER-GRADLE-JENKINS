set projectLocation=D:\Testing workspace\ClinaNG
set tagName01=@loginfunction
set tagName02=@Clinicadmin
d:
cd %projectLocation%
cmd /k gradle cucumber -Dcucumber.options="--tags %tagName01% and --tags %tagName02%%"
pause
