<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
.topnav-right {
  float: right;
}
table {
    border-collapse: collapse;
    border-spacing: 0;
    width: 100%;
    border: 1px solid #ddd;
}

th, td {
    text-align: left;
    padding: 16px;
}

tr:nth-child(even) {
    background-color: #f2f2f2
}

.button {
  border-radius:35px;
  background-color: #f4511e;
  border: none;
  color: #FFFFFF;
  text-align: center;
  font-size: 25px;
  padding: 10px;
  width: 150px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 10px;
  position:200px;
}

.button span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.button span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: 20px;
  transition: 0.5s;
}

.button:hover span {
  padding-right: 25px;
}

.button:hover span:after {
  opacity: 1;
  right: 0;
}

.btn {
  background-color:green;
  border: none;
  color: white;
  padding: 16px 32px;
  text-align: center;
  font-size: 16px;
  margin: 4px 2px;
  opacity: 0.6;
  transition: 0.3s;
}

.btn:hover {opacity: 1}

.info {background-color: #2196F3;} /* Blue */
.info:hover {background: #0b7dda;}

</style>
</head>
<body>
${message}
<br/>
<a href="addjsp"><button class="btn">ADD ASSIGNMENT</button></a>
<a href="view"><button class="btn info">VIEW</button></a>

<div class="topnav-right">
<a href="signout"><button class="button"><span>LOGOUT</span></button></a>
</div>
</body>