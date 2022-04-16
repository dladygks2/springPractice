const uploadFile = document.querySelector('.upload-file');
const addImgBtn = document.querySelector('.add-img-btn');
const uploadImg = document.querySelector('.upload-img');
const imgPreview = document.querySelector('.img-preview');
const imgDeleteBtn = document.querySelector('#img-delete-btn');
const imgAdd = document.querySelector('.img-add');
const uploadContent = document.querySelector('.upload-content');
const uploadSubmitBtn = document.querySelector('.upload-submit-btn');
const form = document.querySelector('form');

imgPreview.style.display = 'none';

var uploadImgFile = '';

uploadFile.onchange = () => {
    let reader = new FileReader();

    reader.onload = (e) => {
        imgPreview.style.display = 'flex';
        imgAdd.style.display = 'none';
        uploadImgFile = e.target.result;
        uploadImg.src = uploadImgFile; // url을 가지고온다
    }

    reader.readAsDataURL(uploadFile.files[0]); // 이미지 파일의 첫번째파일
}

addImgBtn.onclick = () => {
    uploadFile.click();
}

imgDeleteBtn.onclick = () => {
    uploadFile.value = '';
    uploadFile.files[0] = null;
    uploadImg.src = null;
    
    imgPreview.style.display = 'none';
    imgAdd.style.display = 'flex';
}


function isEmpty(str){
	if(typeof(str) == undefined || str == null || str == ''){
		return true;
	}else{
		return false;
	}
}

function uploadSubmit(){
	let formData = new FormData(form);        // 웹파일이 필요하니까 생성해야한다.
	
	$.ajax({
		type: "post",
		url: "/upload",
		data: formData,
		dataType:"text",
		enctype: "multipart/form-data",  // form data를 전달할 때, enctype, processData, contentType 필수로 입력해야한다.
		processData : false,
		contentType: false,
		success: function(data){
			if(data == 'true'){
				alert('게시글 작성 완료');
				location.replace("/");
			}
		},
		error: function(){
			alert('비동기 처리 오류.....');
		}
	});
}

uploadSubmitBtn.onclick = () =>{
	/*alert(uploadFile.value);*/
	if(isEmpty(uploadFile.value)){
		alert('이미지를 추가해 주세요.');
	}else if(isEmpty(uploadContent.value)){
		alert('내용을 입력해 주세요.');
	}else{
		uploadSubmit();
	}
}




