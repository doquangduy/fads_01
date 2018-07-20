<%@include file="/includedTags.jsp"%>

<nav class="navbar navbar-default navbar-static-top">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">

			<button type="button"
				class="navbar-toggle navbar-toggle-sidebar collapsed">MENU
			</button>
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Team Java Framgia</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<li>
					<s:a action="home"><s:text name="client.menu.home" /></s:a>
				</li>
				<li>
					<s:a action="homepage"><s:text name="client.menu.category" /></s:a>
				</li>
				<li>
					<s:a action="favorite-index">
						<s:text name="client.action.favorite" />
					</s:a>
				</li>
				<li>
					<s:a action="postnews">
						<s:text name="news.action.post" />
						<span><i class="glyphicon glyphicon-pencil"></i></span>
					</s:a>
				</li>

					<li><s:a class="btn-success" action="postlist">
						<s:text name="news.action.mypost" />
					</s:a></li>
				<li><a href="http://www.pingpong-labs.com" target="_blank">Visit
						Site</a></li>
				<li class="dropdown "><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">
						Account <span class="caret"></span>
				</a>
					<ul class="dropdown-menu" role="menu">
						<li>${USER.username}</li>
						<li>
							<s:url action="logout" var="logoutUrl"></s:url>
							<s:a href="%{logoutUrl}">
								<s:text name="users.action.logout" />
							</s:a>		
						</li>
						<li><s:url action="viewsChangePass" var="changePassURL"></s:url>
							<s:a href="%{changePassURL}">
								<s:text name="users.action.changePass" />
							</s:a></li>
					</ul></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>