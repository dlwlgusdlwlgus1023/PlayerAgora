<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<table>
		<tr>
			<th
				style="text-align: right; text-align: right; width: 150px; min-width: 150px; padding: 2px 0px 2px 10px;">
				<select name="search_option" class="form-control"
				style="width: 170px;">
					<option value="nick"
						<c:if test="${map.search_option == 'nick'}">selected</c:if>>작성자</option>
					<option value="title"
						<c:if test="${map.search_option == 'title'}">selected</c:if>>제목</option>
					<option value="posts"
						<c:if test="${map.search_option == 'posts'}">selected</c:if>>내용</option>
					<option value="all"
						<c:if test="${map.search_option == 'all'}">selected</c:if>>작성자+내용+제목</option>
			</select>
			</th>
			<th
				style="text-align: right; width: 320px; min-width: 320px; padding: 4px 10px 0px 10px;">
				<fieldset>
					<input type="search" name="keyword" class="search1"
						placeholder="검색어 입력" />
					<button type="submit" class="search2">
						<i class="fa fa-search" aria-hidden="true"></i>
					</button>
				</fieldset>
			</th>
			<th style="text-align: left;">
				<div id="btnWriteDiv">
					<button type="button" id="btnWrite"></button>
				</div>
			</th>

		</tr>
	</table>
