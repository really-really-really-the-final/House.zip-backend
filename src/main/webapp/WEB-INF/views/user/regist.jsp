<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/headmeta.jsp"%>	
<title>happyhouse - sign up</title>
<!-- 아파트 리스트 가져오기-->
<script type="text/javascript" src="../js/aptList.js"></script>
<script type="text/javascript">
        $(document).ready(function() {
        	var isId = true;
        	// 아이디 중복검사
        	$('#userid').keyup(function() {
        		var ckid = $("#userid").val();
        		if(ckid.length < 5 || ckid.length > 15) {
        			$("#idresult").text("아이디는 5자이상 15자이하입니다.").removeClass('text-primary').removeClass('text-dark').addClass('text-danger');
        			isId = true;
        		} 
        		
        		/* else {
	                $.ajax({
	                	url: '${root}/user',
	                	data: {'action': 'idcheck', 'ckid': ckid},
	                  	type: 'GET',
	                  	dataType: 'text',
	                  	success: function (response) {
	                    	var cnt = parseInt(response);
	                    	if(cnt == 0) {
	                    		$("#idresult").text(ckid + "는 사용가능합니다.").removeClass('text-dark').removeClass('text-danger').addClass('text-primary');
	                    		isId = true;
	                    	} else {
	                    		$("#idresult").text(ckid + "는 사용할 수 없습니다.").removeClass('text-dark').removeClass('text-primary').addClass('text-danger');
	                    		isId = false;
	                    	}
	                  	}
					});
        		} */
			});
        	
         	// 회원가입
            $("#registerBtn").click(function () {
                if (!$("#name").val()) {
                    alert("이름 입력!!!");
                    return;
                } else if (!isId) {
                	
                    alert("아이디 확인!!!");
                    return;
                } else if (!$("#password").val()) {
                    alert("비밀번호 입력!!!");
                    return;
                } else {
                    $("#join-form").submit();
                }
            }); 
        });
    </script>
</head>
<body>

	<!-- Navigation-->
	<%@ include file="/WEB-INF/views/include/nav.jsp"%>
	<!-- Page Header-->
	<header class="masthead" style="background-image: url('../assets/img/sign-bg.jpg')">
		<div class="container position-relative post-heading">
			<h1 class="text-center">SIGN UP</h1>
		</div>
	</header>
	<!-- SIGNUP Content-->
	<article class="mb-4">
		<div class="container" style="float: none; margin: 100 auto;">
			<div class="signup-page"
				style="max-width: 500px; float: none; margin: 0 auto;">
				<h1>Welcome</h1>
				<form id="join-form" name="join-form" class="form text-left mb-3" method="post"
					action="${root}/user/regist">
 					<!-- <input type="hidden" name="action" value="register"> -->
					<div class="form-floating">
						<input class="form-control mb-3" id="id" name="id"
							type="text" placeholder="id" /> <label for="id">ID</label>
						<div id="idresult" class="mt-1"></div>
					</div>
					<div class="form-floating">
						<input class="form-control my-3" id="password" name="password"
							type="password" placeholder="password" /> <label for="password">Password</label>
					</div>
					<div class="form-floating">
						<input class="form-control my-3" id="email" name="email"
							type="email" placeholder="email address" /> <label for="email">email</label>
					</div>
					<div class="form-floating">
						<input class="form-control my-3" id="name" name="name"
							type="text" placeholder="name" /> <label for="name">name</label>
					</div>
					<div class="form-floating">
						<input class="form-control my-3" id="joinPhone" name="tel" type="tel" placeholder="010********" />
						<label for="joinPhone" class="mt-3 form-label">phone</label>
					</div>
					<div class="row my-3">
						<h6>관심지역</h6>
						<select class="col me-2 ms-2 m form-control-sm" id="sido">
						</select> <select class="col me-2 form-control-sm" id="gugun">
							<option value="">구군선택</option>
						</select> <select class="col me-2 form-control-sm" name="userdong" id="dong">
							<option value="">동선택</option>
						</select>
					</div>
					<div class="row me-1 ms-0">
						<button class="btn" id="registerBtn"
							style="background-color: #ece6cc;" type="button">회원 가입</button>
					</div>
				</form>
			</div>
		</div>
	</article>

	<%-- footer.jsp를 include해서 재사용하기 --%>
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>