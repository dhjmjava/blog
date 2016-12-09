"use strict"
function updateBloggerInfo(){
	
	$.post("/blog/supervisor/updateBloggerInfo",$("#updateBloggerForm").serialize(),function(data){
		if(data != null){
			if(data.code==-1){
				alert(data.msg);
			}else{
				alert("信息修改成功！");
				setTimeout("window.location.reload()",1500);
			}
		}
	});
	
}