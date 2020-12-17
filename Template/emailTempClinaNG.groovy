<!DOCTYPE html>
<html>
<head>
<style>
table {
  width:100%;
}
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
th, td {
  padding: 6px;
  text-align: left;
}
#t01 tr:nth-child(even) {
  background-color: #eee;
}
#t01 tr:nth-child(odd) {
 background-color: #fff;
}
#t01 th {
  background-color: #80ced6;
  color: white;
}
</style>
</head>
<body>

<h2>JENKINS REPORT</h2>

<table id="t01">
  <tr>
    <th colspan="2"><h3>Build Details</h3></th>
  </tr>
  <tr>
      <td>URL</td>
      <td><A href="${BUILD_URL}">${BUILD_URL}</A></td>
    </tr>
    <tr>
      <td>Project</td>
      <td><A "${env.JOB_NAME}">${env.JOB_NAME}</A></td>
    </tr>
      <tr>
         <td>Build ID</td>
         <td><A "${env.BUILD_ID}">${env.BUILD_ID}</A></td>
      </tr>
      <tr>
         <td>Build Status</td>
         <td><A "${env.currentBuild.currentResult}">${env.currentBuild.currentResult}</A></td>
         <td><A "${env.currentBuild.result}">${env.currentBuild.result}</A></td>
      </tr>
      <tr>
         <td>Build Date</td>
         <td><A "${BUILD_TIMESTAMP}">${env.BUILD_TIMESTAMP}</A></td>
      </tr>
</table>
</body>
</html>
