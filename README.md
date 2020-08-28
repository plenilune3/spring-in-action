# Taco Cloud

Spring Boot 공부를 위한 프로젝트 입니다.

사용자가 원하는 Taco를 만들고 주문하는 서비스 입니다.


## Running Taco Cloud

[Docker-compose](https://docs.docker.com/compose/) 를 통한 빠른 실행 가능

```
% docker-compose up -d
```

실행 후 http://localhost:4200 을 통해 홈페이지에 접속 할 수 있습니다.

## Kicking the tires

아직 모든 기능이 작동하지 않습니다. 필수적인 REST API를 구현하고 있으며, 이미 몇개의 API는 그럭저럭 동작합니다.

홈페이지 상단의 "Latest Taco" 메뉴를 통해 최근에 만든 Taco를 볼 수 있습니다. "Specials"와 "Locations"는 아직 비어있습니다.

"Design a Taco"를 통해 새로운 Taco를 만들 수 있습니다. 오른쪽 "Cart" 모양의 메뉴를 통해 장바구니의 내용을 볼 수 있습니다.


### What's missing/broken

 - Spring Security가 아직 동작하지 않고, 그래서 로그인 페이지가 없습니다.
 - 회원가입을 할 수 있는 방법이 없습니다.

## Modules

멀티 모듈 그래들 프로젝트는 다음과 같은 모듈로 이루어져 있습니다.
 - taco-api : The REST API
 - taco-data : The persistence module
 - taco-domain : The domain types
 - taco-security : The security module (아직 동작하지 않음)
 - taco-ui : A Typescript Angular UI
 - tacos : 다른 모듈을 모으고, 스프링 부트 메인 클래스가 있는 Main module
 
## References

[Spring in action 5th](https://www.manning.com/books/spring-in-action-fifth-edition)
