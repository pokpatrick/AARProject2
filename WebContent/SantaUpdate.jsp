<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
	<head profile="http://gmpg.org/xfn/11">
		<title>Santa's page to Update a Child</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	</head>

	<body>
	    <div id="contact-form" class="clearfix">  
        <h1>Complete form to update a child !</h1>     
        <form method="get" action="PresentResource">
        	<br/>
        	<hr/>
        	<h2>Id for the child to update :</h2>  
            <label for="id">Enter ID :</label>  
            <input type="text" id="id" name="id" value=""/>  
            <hr/>
       		<br/>
       		
        	<h2>Things to update :</h2>  
            <label for="isNaughty">Has the Child been :</label>  
            <input type="radio" title="good" checked="checked" id="isNaughty" name="isNaughty" value="good"/>
            <input type="radio" title="naughty" id="isNaughty" name="isNaughty" value="naughty"/>  
            <hr/>
       		<br/>
            <label for="lastName">If he has been good, validate the wish ? :</label>  
            <input type="radio" title="no" checked="checked" id="isValid" name="isValid" value="no"/>
            <input type="radio" title="yes" id="isValid" name="isValid" value="yes"/>  
            <hr/>
       		<br/>
       		
            <input type="submit" value="Submit" id="submit-button"/>  
            <input type="reset" value="Reset" id="submit-button"/>    
        </form>  
    	</div>  
	</body>
</html>