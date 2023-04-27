<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
    #map04 > #map{
        width:400px;
        height:400px;
        border: 2px solid red;
    }
</style>
<script>

    let map04 = {
        map:null,
        init:function(){
            this.display();
            $('#s_btn').click(function (){
                map04.go(37.63849012743543, 127.01359590433778, 's');
            });
            $('#b_btn').click(function (){
                map04.go(35.17928653687089, 129.07508929338235, 'b');
            });
            $('#j_btn').click(function (){
                map04.go(33.501155116724384, 126.53112145482527, 'j');
            });
        },
        display:function (){
            var mapContainer = document.querySelector('#map04 > #map');
            var mapOption = {
                center: new kakao.maps.LatLng(37.5447889, 127.056768), // 알파코 좌표 찍음
                level: 5 // 지도의 확대 레벨
            };
            map =  new kakao.maps.Map(mapContainer, mapOption) //지도 뿌리기

            // 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
            var mapTypeControl = new kakao.maps.MapTypeControl();
            // 지도에 컨트롤을 추가해야 지도위에 표시됩니다
            // kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
            map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);
            // 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
            var zoomControl = new kakao.maps.ZoomControl();
            map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

            // 마커가 표시될 위치입니다
            var markerPosition  = new kakao.maps.LatLng(37.5447889, 127.056768);
            // 마커를 생성합니다
            var marker = new kakao.maps.Marker({
                position: markerPosition
            });
            // 마커가 지도 위에 표시되도록 설정합니다
            marker.setMap(map);
        },
        go:function (lat, lng, loc){  //위도, 경도, 지역
            var moveLatLon = new kakao.maps.LatLng(lat, lng);
            map.panTo(moveLatLon);  //지도이동

            var markerPosition  = new kakao.maps.LatLng(lat, lng);
            var marker = new kakao.maps.Marker({
                position: markerPosition   //이동된 위치에 마커 뿌리기
            });
            marker.setMap(map);
            map04.markersDB(loc);   //loc정보를 토데로 마커를 달라
        },
        markersDB:function (loc){
            $.ajax({
                url:'/markersDB',
                data:{'loc':loc.toUpperCase()},   //대문자 S, B, J (loc값)이여야 인식
                success:function (data){
                    map04.displaymarkers(data);  //데이터를 주면 마커들을 뿌리는 함수 만듬
                }
            });    //DB에서 받아온 데이터
        },
        displaymarkers:function (positions){   //지역별 데이터(맛집) 마커 뿌리기.  positions라는 이름으로 data를 뿌림.
            var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";   //맛집마커이미지
            for (var i = 0; i < positions.length; i ++) {
                var imageSize = new kakao.maps.Size(20, 30);
                var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);
                var markerPosition = new kakao.maps.LatLng(positions[i].lat, positions[i].lng);

                var marker = new kakao.maps.Marker({
                    map: map,
                    position: markerPosition,
                    title : positions[i].title,
                    image : markerImage
                });   //지역별 3개의 마커가 생성되겠지. 데이터에 각 3개씩 있으니까

                // infoWindow
                var iwContent = '<h4>'+positions[i].title+'</h4>';
                iwContent += '<img src="/uimg/'+positions[i].img+'" style="width:120px">';
                // WebMvcConfig 에서 지정한 경로에서 이미지를 받아옴
                var infowindow = new kakao.maps.InfoWindow({
                    position : markerPosition,
                    content : iwContent
                });   //3개의 인포윈도우가 각각 생성.

                kakao.maps.event.addListener(marker, 'mouseover', mouseoverListener(marker, infowindow));
                kakao.maps.event.addListener(marker, 'mouseout', mouseoutListener(marker, infowindow));
                kakao.maps.event.addListener(marker, 'click', mouseclickListener(positions[i].target));
                // 각각의 마우스 이벤트를 붙이고

                function mouseoverListener(marker, infowindow) {
                    return function(){
                        infowindow.open(map, marker);
                    };    //인포윈도우를 여세요
                }
                function mouseoutListener(marker, infowindow) {
                    return function(){
                        infowindow.close();
                    };     //인포윈도우를 닫으세요
                }
                function mouseclickListener(target) {
                    return function(){
                        location.href = target;
                    };     // 클릭 시 target 주소로 넘어가세요.
                }
            } // end for문
        } // end function
    };
    $(function (){
        map04.init();
    })

</script>


<%-- Main Center Start --%>
<div class="col-sm-8 text-left">
    <div class="container" id="map04">
        <h3>Map04</h3>
        <button id="s_btn" type="button" class="btn btn-primary">Seoul</button>
        <button id="b_btn" type="button" class="btn btn-primary">Busan</button>
        <button id="j_btn" type="button" class="btn btn-primary">Jeju</button>
        <div id="map"></div>
    </div>
</div>
<%-- Main Center End --%>