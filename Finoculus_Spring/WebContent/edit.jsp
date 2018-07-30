<%@page import="java.util.ArrayList"%>
<%@page import="totalcode.Totalcode"%>
<%@page import="pojo.Viewpojo"%>
<!DOCTYPE html>
<html>
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box}

/* Full-width input fields */
input[type=text], input[type=password] {
    width: 100%;
    padding: 15px;
    margin: 5px 0 22px 0;
    display: inline-block;
    border: none;
    background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
    background-color: #ddd;
    outline: none;
}

hr {
    border: 1px solid #f1f1f1;
    margin-bottom: 25px;
}

/* Set a style for all buttons */
button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
    opacity: 0.9;
}

button:hover {
    opacity:1;
}

/* Extra styles for the cancel button */
.cancelbtn {
    padding: 14px 20px;
    background-color: #f44336;
}

/* Float cancel and signup buttons and add an equal width */
.cancelbtn, .signupbtn {
  float: left;
  width: 50%;
}

/* Add padding to container elements */
.container {
    padding: 16px;
}

/* Clear floats */
.clearfix::after {
    content: "";
    clear: both;
    display: table;
}

/* Change styles for cancel button and signup button on extra small screens */
@media screen and (max-width: 300px) {
    .cancelbtn, .signupbtn {
       width: 100%;
    }
}
</style>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

   <script> 


   $(function(){
       var dtToday = new Date();
       
       var month = dtToday.getMonth() + 1;
       var day = dtToday.getDate();
       var year = dtToday.getFullYear();
       if(month < 10)
           month = '0' + month.toString();
       if(day < 10)
           day = '0' + day.toString();
       
       var minDate= year + '-' + month + '-' + day;
       
       $('#txtDate').attr('min', minDate);
   });
</script>
<body>
<%String ai=request.getParameter("aid");
int aid=Integer.parseInt(ai);
String id="";
try{
id=(String)session.getAttribute("ses");
if(id.equals("")){
	response.sendRedirect("Login.jsp");

	
}
}
catch(Exception e){
	response.sendRedirect("Login.jsp");
}


 Totalcode t=new Totalcode();
 Viewpojo vp=t.viewbyid(id,aid);


%>
<form action="editassignment" method="post" "border:1px solid #ccc">
  <div class="container">
  
    
    <label for="assignname"><b>Assignname</b></label>
    <input type="text" placeholder="Enter assignnamel" name="assignname" value="<%=vp.getAssignname()%>"required>

    <label for="assigndate"><b>Assigndate</b></label>
    <input id="txtDate" type="date" placeholder="Enter assigndate" name="assigndate" value=<%=vp.getAssigndate()%> required>
<br>
<br>
    <label for="status"><b>Status</b></label>
    <select name="status" value="<%=vp.getStatus() %>">
  <option value="COMPLETED"> COMPLETED</option>
  <option value="INCOMPLETE">INCOMPLETE</option>
  
</select>
   
    <input type="hidden" name="aid" value="<%=vp.getAid()%>">
  
    <div class="clearfix">
    <a href="viewassignment">  <button type="button" class="cancelbtn">Back</button></a>
      <button type="submit" class="signupbtn">Confirm</button>
    </div>
  </div>
</form>

</body>
</html>
