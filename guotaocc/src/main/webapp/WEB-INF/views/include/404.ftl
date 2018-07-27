<!DOCTYPE html>
<html>
<head>
	<title>404</title>
</head>
<body>
	<!--main content start-->
	<section id="main-content">
		<section class="wrapper">
			<div class="row">
            	<div class="col-lg-12">
            		<section class="panel">
						<header class="panel-heading">
                            	404
                        </header>
				        <div class="panel-body">
                   			${msg!''}
				        </div>
				    </section>
				</div>
			</div>
		</section>
	</section>
	<!--main content end-->
	
 	<script src="../resources/common/js/common.js"></script> 
	<script type="text/javascript">
		var contextPath = "${request.contextPath}";
		$(document).ready(function() {
			$("#dashboard_a").addClass("active");
			$("#dashboard_sub").css('display', 'block');
			$("#userAccountMenu").addClass("active");
		});
	</script>
</body>
</html>