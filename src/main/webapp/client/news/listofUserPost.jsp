<%@include file="/includedTags.jsp"%>
<div class="col-sm-12">
	<!-- <div class="alert alert-success">Added user success!</div> -->
	<table class="table table-striped">
		<tr id="tbl-first-row">
			<td><s:text name="news.action.tittle" /></td>
			<td><s:text name="news.action.phonenumber" /></td>
			<td><s:text name="news.action.price" /></td>
			<td><s:text name="news.action.creatdate" /></td>
			<td><s:text name="news.action.categories" /></td>
			<td><s:text name="news.action.city" /></td>
			<td><s:text name="news.action.image" /></td>
			<td width="5%"><s:text name="users.action.edit" /></td>
			<td width="5%"><s:text name="users.action.delete" /></td>
		</tr>
		<s:iterator value="postList">
			<tr>
				<td><s:property value="tittle" /><br /></td>
				<td><s:property value="phoneNumber" /><br /></td>
				<td><s:property value="price" /><br /></td>
				<td><s:property value="createDate" /><br /></td>
				<td><s:property value="category.name" /><br /></td>
				<td><s:property value="city.name" /></td>
				<td><s:iterator value="newsImages">
						<img class="img-thumbnail"
							src="<c:url value='/assets/images/${name}'/>">
					</s:iterator></td>
				<s:url action="editnews" var="editnews">
					<s:param name="id" value="id" />
				</s:url>
				<td><s:a href="%{editnews}">
						<s:text name="users.action.edit" />
					</s:a></td>
				<s:url action="delnews" var="delnews">
					<s:param name="id" value="id" />
				</s:url>
				<td><s:a href="%{delnews}">
						<s:text name="users.action.delete" />
					</s:a></td>
			</tr>
		</s:iterator>
	</table>
</div>