<%@include file="/includedTags.jsp"%>
<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">
				<s:text name="news.action.penel" />
			</h1>
		</div>
	</div>
	<!--/.row-->

	<div class="row">
		<div class="col-xs-12 col-md-12 col-lg-12">

			<div class="panel panel-primary">
				<div class="panel-heading">
					<s:text name="news.action.head" />
				</div>
				<div class="panel-body">
					<c:url var="createNewsUrl" value="/createNewsForm" />
					<form
						action="${createNewsUrl}?${_csrf.parameterName}=${_csrf.token}"
						method="post" enctype="multipart/form-data" validate="true">
						<div class="row" >
							<div class="col-xs-8">
								<div class="form-group">
									<label><s:text name="news.action.tittle" /></label> <input
										type="text" name="news.tittle" class="form-control">
									<s:fielderror fieldName="news.tittle"></s:fielderror>
								</div>
								<div class="form-group">
									<label><s:text name="news.action.content" /></label>
									<s:textarea class="form-control" rows="5" name="news.content"></s:textarea>
									<s:fielderror fieldName="news.content"></s:fielderror>
								</div>

								<div class="form-group">
									<label><s:text name="news.action.phonenumber" /></label>
									<s:textfield name="news.phoneNumber" class="form-control"></s:textfield>
									<s:fielderror fieldName="news.phoneNumber"></s:fielderror>
								</div>
								<div class="form-group">
									<label><s:text name="news.action.price" /></label>
									<s:textfield name="news.price" class="form-control"></s:textfield>
									<s:fielderror fieldName="news.price"></s:fielderror>
								</div>
								<input type="hidden" name="news.startDate" class="form-control">
								<input type="hidden" name="news.endDate" class="form-control">
								<div class="form-group">
									<label><s:text name="news.action.image" /></label>
									<s:file name="myFiles" label="Select a File to upload" />
									<s:file name="myFiles" label="Select a File to upload" />
									<s:file name="myFiles" label="Select a File to upload" />
									<s:fielderror fieldName="news.images"></s:fielderror>

								</div>
								<div class="form-group">
									<label><s:text name="news.action.categories" /></label> <select
										name="news.category.id" class="form-control">
										<s:iterator value="categories">
											<option value="${id}">
												<s:property value="name" /> <br />
											</option>
										</s:iterator>

									</select>
								</div>
								<div class="form-group">
									<label><s:text name="news.action.city" /></label> <select
										name="news.city.id" class="form-control">
										<s:iterator value="cities">
											<option value="${id}">
												<s:property value="name" /> <br />
											</option>
										</s:iterator>
									</select>
								</div>
								<s:submit type="submit" name="submit" value="Post"
									class="btn btn-primary"></s:submit>
								<s:a class="btn btn-danger" action="homepage">
									<s:text name="news.action.cancel" />
								</s:a>
							</div>
						</div>
					</form>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
	<!--/.row-->
</div>
