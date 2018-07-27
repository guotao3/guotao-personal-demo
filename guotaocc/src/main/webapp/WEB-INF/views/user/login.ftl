<!DOCTYPE HTML>
<html>
<head>
<title>Simple Login Form</title>
<meta charset="UTF-8" />
<meta name="Designer" content="PremiumPixels.com">
<meta name="Author" content="$hekh@r d-Ziner, CSSJUNTION.com">
<link rel="stylesheet" type="text/css" href="../resources/css/login.css">
<link rel="stylesheet" type="text/css" href="../resources/css/structure.css">
</head>

<body>
<form class="box login">
	<fieldset class="boxBody">
	  <label>用户名</label>
	  <input type="text" tabindex="1" id="loginMobile" placeholder="请输入用户名" required>
	  <label><a href="#" class="rLink" tabindex="5">Forget your password?</a>密码</label>
	  <input type="password" placeholder="请输入密码" id="loginPassword" tabindex="2" required>
	</fieldset>
	<footer>
	  <label><input type="checkbox" tabindex="3">Keep me logged in</label>
	  <input type="button" class="btnLogin" onclick="login()" value="登录" tabindex="4">
	</footer>
</form>
</body>
   <script src="../resources/js/jquery.min.js"></script>
   <script type="text/javascript">
    var contextPath = "${request.contextPath}";
   	function login() {
		var mobile = $("#loginMobile").val();
		var password = $("#loginPassword").val();

		if(null == mobile || mobile.trim() == '' || mobile == 'undefined') {
			alert("会员登录账号不能为空!");
			return false;
		}
		
		if(null == password || password.trim() == '' || password == 'undefined') {
			alert("登录密码不能为空!");
			return false;
		}
		
		var params = {'mobile' : mobile,'password' : password };
		jQuery.ajax({
			data : params,
	        async : false,
	        type : "POST",
	        timeout: 60000,
	        url : contextPath+"/user/login.json",
	        dataType  :"json",
	        exception : function(data){
	        },
	        error : function(data){
	        },
	        success: function(data) {
	        	if(data.status) {
	        		window.location.href = contextPath+ '/new/newsList.html';
	        	}else {
	        		alert(data.errorMessage);
	        	} 
	        }
	    });
	}  	 
   
   </script>
</html>
