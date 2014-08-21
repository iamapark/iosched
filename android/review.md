Google 2014 I/O ioshced App 정리
==================


<h2>앱 최초 실행</h2>
 - 앱 실행 시 가장 먼저 실행되는 액티비티는 BrowseSessionsActivity이다.
 - BrowseSessionActivity는 BaseActivity를 상속한다. BaseActivity는 onStart에서 Bootstrap 데이터가 메모리에 올라와있는지 검사한 후 그렇지 않다면 Bootstrap데이터를 읽어와 파싱한다.
 - 여기서 불러오는 데이터의 위치는 [여기](src/main/res/raw/bootstrap_data.json)이다. 앱 최초 실행 시 해당 json을 파싱하여 메모리에 올리고 그 다음 실행부터는 파싱하지 않는다.
 - 여기서 데이터가 저장되는 공간이 메모리인지 아니면 다른 persist한 공간인지 살펴볼 것!(로그인 정보를 저장할 수도 있음)
 
 
<h2>세션</h2>
 - 각 세션의 디테일 뷰는 SessionDetailFragment를 사용한다. (Fragment 기능!!)
 - 세션 리스트는 BrowseSessionActivity를 사용한다. BaseAcrivity를 상속하여 기능을 확장함.