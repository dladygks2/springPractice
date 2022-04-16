<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<form enctype="multipart/form-data">
        <div>
            <input type="file" id="file_uploads" name="file" multiple>
        </div>
        <button type="button">삭제</button>
        <button type="button">전송</button>
        
        <img src="">
    </form>

    <script>
        const input = document.querySelector('input');
        const preview = document.querySelector('.preview');
		const img = document.querySelector('img');
        const form = document.querySelector('form');
        const button = document.querySelectorAll('button');
        var fileListAsArray = [];
        var dataTransfer = new DataTransfer();
        
        button[0].onclick = () => {
        	fileListAsArray = Array.from(input.files);
            fileListAsArray.splice(1, 1);
            fileListAsArray.forEach(file => { dataTransfer.items.add(file); });
            input.files = dataTransfer.files;
        }
        
        input.onchange = () => {
        	alert("호출?")
        	let reader = new FileReader();
        	
        	reader.onload = (e) => {
        		imgFileChangeFlag = true;
        		img.src = e.target.result;
        	}
        	
        	reader.readAsDataURL(input.files[0]);
        }
        
        button[1].onclick = () => {
        	let formData = new FormData(form);
            //formData.delete('file');
            //formData.set('file', fileListAsArray);
            
            $.ajax({
            	type: "post",
            	url: "/file-insert",
            	data: formData,
        		dataType: "text",
        		enctype: "multipart/form-data",
        		processData: false,
        		contentType: false,
        		success: function(data){
        			alert('문제없음');
        		},
        		error: function(){
        			alert('문제있음');
        		}
            })
            
        }
        
    </script>
</body>
</html>