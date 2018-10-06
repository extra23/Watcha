<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<style>
	
		.bbs{position:relative; float:left; width:647px; margin:22px 12px 0 0; border-bottom:1px solid #e5e5e5;}
		.bbs li{float:left;}
		.bbs li a{display:block;}
		.bbs li.last-child{background:none;}
		.bbs li a:hover,
		.bbs li.current a{color:#59626e;}
		.bbs ul{position:absolute; top:40px; left:0; padding:0 8px 0 0;}
		.bbs ul li{width:295px; margin:0 0 0 13px; padding:0 0 0 8px; letter-spacing:-1px; line-height:1.85em;}
		.bbs ul li span{margin:0 5px 0 0; font-weight:normal; color:#a2b068; font-size:11px; font-family:dotum;}
		.bbs li.current ul a,
		.bbs li ul a{display:inline; padding:0; font-weight:normal; color:#999; font-size:11px; font-family:dotum; background:none; border:0;}
	
	</style>

</head>
<body>

	<ul class="bbs">
		<li class="current"><a href="#" class="freeboard">자유게시판</a></li>
		<li><a href="#" class="notice">공지사항</a></li>
	</ul>
	
	<script type="text/javascript">
		//<![CDATA[
		$(function() {
			$('ul.bbs > li > a').click(function() {
				$(this).parent().css('background', 'url(/images/load_black.gif) 0 8px no-repeat'); //탭에 로딩이미지 표시
				getLatest($(this));
				return false;
			});
			var getLatest = function($this) {
				$.ajax({
					async: false,
					cache: false,
					type: "POST",
					dataType: 'json',
					url: "<?php echo $g4['path'];?>/latest.ajax.php",
					data: {
						'bo_table': $this.attr('className'), //게시판ID
						'sst': 'wr_datetime', //order by $sst $sod
						'sod': 'desc',
						'count': 8, //limit
						'subject_cut': 60, //제목길이
					},
					success: function(data) {
						if(data == 'Fail') {
							alert('요청 오류!!');
							$this.parent().css('background', 'none');
							return false;
						}
						if(data != null) {
							$('ul.bbs > li > ul').remove();
							var list_li = '';
							$.each(data, function(i, v) {
								idNum = i + 1;
								var img = '';
								if(i == 0) $this.parent().append('<ul></ul>');
								list_li += '<li id="bbs_'+ idNum +'"><span class="date">[ ' + v.wr_datetime + ' ]</span><a href="/bbs/board.php?bo_table=' + $this.attr('className') + '&wr_id=' + v.wr_id + '">' + v.subject + '</a></li>';
							});
							$('ul.bbs > li > ul').append(list_li);
							$('ul.bbs > li').removeClass('current');
							$this.parent().addClass('current'); //클릭한 탭 li에 current클래스 추가
						} else {
							alert('요청하신 데이터가 존재하지 않습니다.');
						}
						$this.parent().css('background', 'none'); //로딩 완료 후 로딩이미지 제거
					}
				});
			};
		getLatest($('ul.bbs > li:first > a')); //페이지 로딩시 첫번째 탭 자동으로 로드
		//]]>
	</script>

</body>
</html>