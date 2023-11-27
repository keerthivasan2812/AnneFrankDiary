<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.Map"%>
<%@page import="java.util.Set"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DiaryView</title>
</head>
<body>

<h1>VIEW DIARY ENTRIES</h1>
<br>
<form action="Diaryv">

<label for="date">diaryentries</label>
<select id="date" name="date">
 
            <%-- Access the diaryview map directly and generate <option> tags --%>
            <% Map<String, String> diaryview = (Map<String, String>) request.getAttribute("diaryview");
		if (diaryview != null) {
			 String selecteddate = request.getParameter("date");
            for (String date : diaryview.keySet()) { %>
                <option value="<%= date %>"><%= date %></option>
            <% }	
        } %>

</select>
<br>
<textarea rows="30" cols="200" name="diary" >

<% String selecteddate=request.getParameter("date");


if(selecteddate!=null&&diaryview!=null&&diaryview.containsKey(selecteddate)){
	
	out.print(diaryview.get(selecteddate));
	
}
else{
	out.print("Select a date from the dropdown to view the diary entry.");
}

%>

</textarea>
<br><input type="submit" value="view">&nbsp;&nbsp;&nbsp;<button onclick="updateDiary()">update</button>

</form>



<script type="text/javascript">
function updateDiary() {
            var selectedDate = document.getElementById("date").value;
            var diaryText = document.querySelector("textarea[name=diary]").value;

            var xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4) {
                    if (xhr.status === 200) {
                    	console.log("Diary entry updated successfully!");
                    	alert("Diary entry updated successfully!");
                    } else {
                    	console.log("Error updating diary entry. Please try again.");
                    	alert("Error updating diary entry. Please try again.");
                    }
                }
            };
            xhr.open("POST", "Update", true);
            xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xhr.send("date=" + encodeURIComponent(selectedDate) + "&diary=" + encodeURIComponent(diaryText));
            
}            
            
            function viewDiary() {
                
}	
</script>
</body>
</html>