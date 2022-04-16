<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Instagram</title>
    <link rel="stylesheet" href="/css/my_profile.css">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=APIKEY&libraries=services"></script>
</head>

<body>
    <section>
        <jsp:include page="../include/nav.jsp"></jsp:include>
        <main>
            <div class="container">
                <div id="map" style="width:100%;height:600px;"></div>
			    <script type="text/javascript"
			        src="//dapi.kakao.com/v2/maps/sdk.js?appkey=91fc636d1260388bc71cb98c21d391c7"></script>
			    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=APIKEY&libraries=services"></script>    
			    <script>
			        var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
			        var options = { //지도를 생성할 때 필요한 기본 옵션
			            center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
			            level: 3 //지도의 레벨(확대, 축소 정도)
			        };
			
			        var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
			        
			        function locationLoadSuccess(pos){
			            // 현재 위치 받아오기
			            var currentPos = new kakao.maps.LatLng(pos.coords.latitude, pos.coords.longitude);
			            // 지도 이동(기존 위치와 가깝다면 부드럽게 이동)
			            map.panTo(currentPos);
			            // 마커 생성
			            var marker = new kakao.maps.Marker({
			                position: currentPos
			            });
			            // 기존에 마커가 있다면 제거
			            marker.setMap(null);
			            marker.setMap(map);
			        };
			        function locationLoadError(pos){
			            alert('위치 정보를 가져오는데 실패했습니다.');
			        };
			        // 위치 가져오기 버튼 클릭시
			        navigator.geolocation.getCurrentPosition(locationLoadSuccess, locationLoadError);
			    </script>
            </div>
        </main>
    </section>
    <script src="/js/my_profile.js"></script>
</body>

</html>