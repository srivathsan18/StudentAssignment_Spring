<style>
.btn {
    border: none;
    color: white;
    padding: 14px 28px;
    font-size: 16px;
    cursor: pointer;
}
.warning {background-color: #ff9800;} /* Orange */
.warning:hover {background: #e68a00;}

</style>

<h1>Are you sure do you want to delete</h1>
<%
	String	id=(String)session.getAttribute("ses");
    int aid=Integer.parseInt(request.getParameter("aid"));
%>
<form action="deleteassignment" method="post" >
<input type="hidden" name="id" value="<%=id %>">
<input type="hidden" name="aid" value="<%=aid %>">
<button class="btn warning">confirm</button>
</form>
<a href="viewassignment">BACK</a>