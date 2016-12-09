"use strict"
//刷新验证码
function reloadCaptcha(){
	$.post("/blog/loadCaptcha",function(data){
         $("#randImage").attr("src","/blog/loadCaptcha");
	});
}

//提交评论
function submitData(){
	var content = $("#content").val().trim();
	var captchaCode = $("#captchaCode").val().trim();
	
	if(!checkValue(content)){
		alert("评论内容不能为空！");
		return false;
	}
	if(!checkValue(captchaCode)){
		alert("请输入验证码！");
		return false;
	}
	
	$.ajax({
		url : "/blog/submit-comment",
		type : "POST",
		data : {
			"blogId":blogId,
			"captchaCode" : $("#captchaCode").val(),
			"content":$("#content").val()
		},
		success : function(data) {
			if(data.code==-1){
				alert(data.msg);
			}else{
				window.location.reload();
			}
		},
		error : function(data) {
			alert("评论失败！");
		}
	})
	
	function checkValue(value){
		if(null == value || '' == value || undefined == value){
			return false;
		}
		return true;
	}
	
}