# Retrofit2 - REST API 통신 라이브러리

## 3가지 구성요소 
- DTO(Data Transfer Object): Model 정의
- Interface : CRUD HTTP Method 정의
- Retrofit.Builder Class (Remote DataSource)

## 사용방법 with MVVM
1️⃣ Gradle 의존성 추가  

2️⃣ 인터넷 권한 설정  

3️⃣ DTO 모델 Class 생성 (data > model)
   - 응답 데이터 구조에 맞게 모델 클래스 선언  

4️⃣ Interface 정의 (data > repository)  

5️⃣ Retrofit 인스턴스 생성 (data > repository)  
   - Entity API를 통해 Data를 가져오는 

6️⃣ Repository 클래스 정의 (data > repository)
   - 데이터 소스로부터 Model을 가져오는 것을 추상화
   - 레이어끼리의 의존성↓

<br>

❕ data폴더가 MVVM에서의 Model에 해당!   
❕ data > repository 에는 local, remote 등 다양한 DB, API저장 가능  
❕ Repository 클래스에서 모든 Datasource와의 상호작용을 추상화


## 참고
[Retrofit2 공식 문서](http://devflow.github.io/retrofit-kr/)  
[Retrofit2 사용법](https://jaejong.tistory.com/33)  
[MVVM 폴더구조](https://0391kjy.tistory.com/14)  

<br>

# 🛠 내가 마주한 Error!

- CLEARTEXT communication to XXXX not permitted by network security policy  
❔ 에러 원인: API 주소가 https가 아닌 http로 되어있어서!  
💡 해결책: AndroidManfest.xml의 <application ... android:usesCleartextTraffic="true">  
[참고](https://gun0912.tistory.com/80)