<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>image loader</title>
</head>
<body>


<form method="post" action="<%=request.getContextPath() %>/FileUploadServlet" enctype="multipart/form-data">

<label class="col-4" for="photoArticle" >Photo de l'article : </label>          
			<input class="col-6 form-control-file" type="file" name="file" size="150"
                   /> <br/> 
            <input type="submit" value="Upload" /> <br/>  


</form>

<h4>this is ajax</h4>

<input id="ajaxfile" type="file"><br>
<button onclick="uploadFile()">Upload</button>

<script>
async function uploadFile(){
	let formData = new FormaData();
	formData.append("file", ajaxfile.files[0]);
	await fetch('FileUploadServlet', {
		method: "POST",
		body: formData
	});
	alert('upload ok');
}

</script>

</body>
</html>