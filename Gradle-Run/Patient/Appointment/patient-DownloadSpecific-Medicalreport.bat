set projectLocation=D:\Testing workspace\ClinaNG
set tagName=@DownloadSpecific-Medicalreport
d:
cd %projectLocation%
cmd /k gradle cucumber -Dcucumber.options="--tags %tagName%"
pause
