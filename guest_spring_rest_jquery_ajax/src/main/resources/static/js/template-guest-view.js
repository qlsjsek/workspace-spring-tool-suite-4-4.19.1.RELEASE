/**
 * 
 */
export function guest_view(responseJsonObject={}) {
	let htmlTemplate =
	`
		<table border="0" cellpadding="0" cellspacing="0">
		<tbody>
		<tr>
			<td>
				<!--contents--> <br>
				<table style="padding-left: 10px" border="0" cellpadding="0"
					cellspacing="0">
					<tbody>
						<tr>
							<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>방명록 관리 -
									방명록 상세보기</b></td>
						</tr>
					</tbody>
				</table> <!-- view Form  -->
				{{#with data.[0] }}
				<form name="f" method="post">
					<input type="hidden" name="guest_no" value="{{guest_no}}">
					<table border="0" cellpadding="0" cellspacing="1" width="590"
						bgcolor="BBBBBB">
						<tbody>
							<tr>
								<td width="100" align="center" bgcolor="E6ECDE" height="22">번호</td>
								<td width="490" bgcolor="ffffff" align="left"
									style="padding-left: 10px">{{guest_no}}</td>
							</tr>
							<tr>
								<td width="100" align="center" bgcolor="E6ECDE" height="22">이름</td>
								<td width="490" bgcolor="ffffff" align="left"
									style="padding-left: 10px">{{guest_name}}</td>
							</tr>
							<tr>
								<td width="100" align="center" bgcolor="E6ECDE" height="22">날짜</td>
								<td width="490" bgcolor="ffffff" align="left"
									style="padding-left: 10px">{{guest_date}}</td>
							</tr>
							<tr>
								<td width="100" align="center" bgcolor="E6ECDE" height="22">홈페이지</td>
								<td width="490" bgcolor="ffffff" align="left"
									style="padding-left: 10px">{{guest_homepage}}</td>
							</tr>
							<tr>
								<td width="100" align="center" bgcolor="E6ECDE" height="22">제목</td>
								<td width="490" bgcolor="ffffff" align="left"
									style="padding-left: 10px">{{guest_title}}</td>
							</tr>
							<tr>
								<td width="100" align="center" bgcolor="E6ECDE" height="110">내용</td>
								<td width="490" bgcolor="ffffff" align="left"
									style="padding-left: 10px">{{guest_content}}</td>
							</tr>
						</tbody>
					</table>
				</form> 
				{{/with}}
				<br>
				<table width="590" border="0" cellpadding="0" cellspacing="0">
					<tbody>
						<tr>
							<td align="center">
								<input type="button" data-navigate="/guest_modify_form/{{data.[0].guest_no}}" value="수정" id="btn_guest_modify_form" guest_no="{{data.[0].guest_no}}">
								&nbsp; 
								<input type="button" data-navigate="/guest_remove_action/{{data.[0].guest_no}}" value="삭제" id="btn_guest_remove_action" guest_no="{{data.[0].guest_no}}">
								&nbsp; 
								<input type="button" data-navigate="/guest_list" value="목록" id="btn_guest_list">
							</td>
						</tr>
					</tbody>
				</table>
			</td>
		</tr>
	</tbody>
	</table>
	`;
	let bindTemplate=Handlebars.compile(htmlTemplate);
	let resultTemplate=bindTemplate(responseJsonObject);
	return resultTemplate;
}