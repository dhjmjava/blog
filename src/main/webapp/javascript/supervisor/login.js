	function login(){
		var username = $("#username").val().trim();
		var pwd = $("#password").val().trim();
		if(username == null || username == ''){
			$("#userName_id").html("*请输入用户名！");
			return false;
		}
		if(pwd == null || pwd == ''){
			$("#pwd_id").html("*请输入密码！");
			return false;
		}
		
		$.ajax({
			url : "/blog/supervisor/checkLogin",
			type : "POST",
			data : {
				"username" : username,
				"pwd":pwd
			},
			success : function(data) {
				if(data.code==-1){
					$("#pwd_id").html(data.msg);
				}else{
					window.location.href="/blog/supervisor/index.html";
				}
			},
			error : function(data) {
				alert("you are holder a problem！");
			}
		});
	}
