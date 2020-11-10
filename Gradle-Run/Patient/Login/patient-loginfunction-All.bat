set projectLocation=D:\Testing workspace\ClinaNG
set tagName01=@clinicadmin:login_valid
set tagName02=@clinicadmin:login_invalid
d:
cd %projectLocation%
cmd /k gradle cucumber -Dtags=%tagName01%,%tagName02%
pause
