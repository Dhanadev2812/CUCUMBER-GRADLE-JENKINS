set projectLocation=D:\Testing workspace\ClinaNG
set tagName01=@Bookappointment
set tagName02=@Appointment
d:
cd %projectLocation%
cmd /k gradle cucumber -Dtags=%tagName01%,%tagName02%
pause
