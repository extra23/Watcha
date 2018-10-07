<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		
		#star-rating-outer {width: 205px; height: 39px; overflow: hidden; z-index: 0;}
		
		#star-rating-inner {display: inline-block; width: 205px; height: 39px; overflow: hidden;}
		
/* 		#star-rating-outer, #star-rating-inner {display: inline-block; height: 39px; overflow: hidden; background: url("images/star.png") no-repeat;}
		
		#star-rating-inner {background-position: left bottom; line-height: 0; vertical-align: top;} */
		
	</style>
</head>
<body>

<!-- 	<div id="star-rating-outer"  onclick="event()">
		<div id="star-rating-inner" style="width: 0"></div>
	</div> -->
	
	<canvas id="canvas" onclick="event()"></canvas>
		
		<div id="star-rating-inner" style="width: 100px; overflow: hidden; position: absolute; top: 7px; left: 8px; z-index: 2;">
			<img src="images/starRed.png" style="z-index: 2;">
		</div>
	
	<script>
	
		function coordinate(x1, y1, x2, y2, width){
			
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
			this.width = width;
			
			this.isInner = function(x, y){
				if(x >= x1 && y >= y1 && x < x2 && y < y2){
					return true;
				}else {
					return false;
				}
			}
			
		}
		
		var coordinateArr = new Array(5);
			coordinateArr.push(new coordinate(0, 0, 40, 40, 42));
			coordinateArr.push(new coordinate(40, 0, 82, 40, 82));
			coordinateArr.push(new coordinate(82, 0, 123, 40, 122));
			coordinateArr.push(new coordinate(123, 0, 164, 40, 164));
			coordinateArr.push(new coordinate(164, 0, 205, 40, 205));
		
		function event(){
			
			var x = event.offsetX;
			var y = event.offsetY;
			
			for(let i = 0; i < 5; i++){
				if(coordinateArr[i].isInner(x, y)){
					console.log(coordinateArr[i].width);
					/* document.getElementById("star-rating-inner").style.width =  + "px"; */
				}else{
					continue;
				}
			}
			
		}
			
		var canvas = document.getElementById("canvas");
		var context = canvas.getContext("2d");
		var img = new Image();
		img.src = "images/starGray.png";
		context.drawImage(img, 0, 0);
	
	</script>

</body>
</html>