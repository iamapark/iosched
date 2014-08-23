Google 2014 I/O ioshced App 정리
==================


## 앱 최초 실행
 - 앱 실행 시 가장 먼저 실행되는 액티비티는 BrowseSessionsActivity이다.
 - BrowseSessionActivity는 BaseActivity를 상속한다. BaseActivity는 onStart에서 Bootstrap 데이터가 메모리에 올라와있는지 검사한 후 그렇지 않다면 Bootstrap데이터를 읽어와 파싱한다.
 - 여기서 불러오는 데이터의 위치는 [여기](src/main/res/raw/bootstrap_data.json)이다. 앱 최초 실행 시 해당 json을 파싱하여 메모리에 올리고 그 다음 실행부터는 파싱하지 않는다.
 - 여기서 데이터가 저장되는 공간이 메모리인지 아니면 다른 persist한 공간인지 살펴볼 것!(로그인 정보를 저장할 수도 있음)

### Data Bootstrap
 - Thread 를 통해 백그라운드에서 실행
 - Conference에서 쓰이는 모든 데이터는 bootstrap_data.json에 저장되어 있음.
 - 이 데이터는 ConfereneDataHandler에서 초기 파싱, 저장, 관리함
 - 하나의 데이터를 나타내는 개념들은 JsonHandler를 상속하여 일정한 형식을 강요받는다. JsonHandler에서는 Gson 형태를 파싱하여 HashMap(Key:id, Value:데이터) 형태로 저장한다.
 - SessionsHandler 는 TagsHandler, SpeakersHandler에서 관리하는 HashMap을 알고 있어야 한다.
 - 각 데이터의 handler 별로 Content provider를 등록한다.
 - content provider 에서는 batch를 통하여 SQLite에 저장(확실하지 않음)
 - Preference에 timestamp를 저장하여 최초 기동시 데이터 재다운로드 여부를 판별한다. <br>
 ```
 PreferenceManager.getDefaultSharedPreferences(mContext).edit().putString(
                   SP_KEY_DATA_TIMESTAMP, timestamp).commit();
 ```
 
#### To be Ssamtong
 - 앱 최초 기동 시 데이터를 받아온 후 서버에 데이터 업데이트가 있기 전까지는 초기 데이터를 다운로드 하지 않는다.
 - 데이터 다운로드 받을지 여부는 앱 기동 시 서버 데이터 timestamp를 비교한다.
 - 서버 timestamp가 앱에 저장된 것보다 크면 기존 앱에 저장된 데이터 삭제 후 서버에서 다시 내려받고 앱 timestamp를 업데이트 한다.
 - 좀 더 향상된 버전에서는 변경된 부분만 다운로드 하도록....
 
 
### Login Process
 - 데이터 초기화 이후 곧바로 로그인 프로세스가 실행된다.
 
 
## 세션
 - 각 세션의 디테일 뷰는 SessionDetailFragment를 사용한다. (Fragment 기능!!)
 - 세션 리스트는 BrowseSessionActivity를 사용한다. BaseAcrivity를 상속하여 기능을 확장함.