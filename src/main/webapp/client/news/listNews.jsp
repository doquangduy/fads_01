<%@include file="/includedTags.jsp" %>
<div class="row">
	<div class="row" id="search">
		<c:url var="newsList" value="/news-list"/>
		<form id="search-form" action="${newsList}?${_csrf.parameterName}=${_csrf.token}" method="POST" enctype="multipart/form-data">
			<s:textfield name="id" type="hidden"></s:textfield>
			<div class="row">
				<div class="form-group col-xs-9">
					<s:textfield class="form-control" placeholder="Search" name="keyword"  id="searchTittle"></s:textfield>
				</div>
				<div class="form-group col-xs-3">
					<s:submit class="btn btn-block btn-primary" value="Search"></s:submit>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-sm-3 col-xs-6">
					<s:select list="cityNames" class="form-control" name="choiceAdress"></s:select>
				</div>
			</div>
		</form>
	</div>
</div>
<div class="row">
	<div class="col-md-8">
		<table class="table">
			<thead>
				<tr>
					<td class="name"><s:text name="client.list.new" /></td>
				</tr>
			</thead>
			<s:iterator value="newses" var="news">
				<tbody>
					<tr>
						<td></td>
						<td>
							<s:url action="news-detail" var="newsDetail">
								<s:param name="id">${id}</s:param>
							</s:url>
							<div class="title">
								<s:a href="%{newsDetail}">${tittle}</s:a>
							</div>
							<div class="price">
								${price}$
							</div>
							<div class="time">
								Post date:<s:date name="startDate" format="dd/MM/yyyy" />
							</div>
							<div class="postBy">
								Post by:<s:property value="#news.user.username"/>
							</div>
						</td>
					</tr>
				</tbody>
			</s:iterator>
		</table>
	</div>
	<div class="col-md-4"></div>
</div>