## GraphQL + Spring WebFlux + Kotlin + r2dbc + Mysql
### Based on Clean Architecture
- [Ref.1](https://medium.com/swlh/graphql-kotlin-tutorial-344f5fe0c71a)
- [Ref.2](https://www.graphql-java.com/tutorials/getting-started-with-spring-boot/)
- [Ref.3](https://velog.io/@jay2u8809/SpringBoot-GraphQL%EC%9D%84-%EC%8D%A8%EB%B3%B4%EC%9E%90)
---
### Env
```text
- jdk 17
- kotlin
- spring 2.6.3
- webFlux
- r2dbc
- mysql 5.7
```

### Issue
1. [Root resolvers Not found](https://stackoverflow.com/questions/60357247/mapping-multiple-graphql-schema-files-to-separate-resolvers-spring-boot)
   - Resolver에 @Component 붙여서 해결
   ```text
   No Root resolvers for mutation type 'Mutation' found!  Provide one or more com.coxautodev.graphql.tools.GraphQLMutationResolver to the builder.
   ```


### 1. dependeny
- GraphQL
```kotlin
//graphql
implementation ("com.graphql-java-kickstart:graphql-spring-boot-starter:6.0.1")
runtimeOnly ("com.graphql-java-kickstart:graphiql-spring-boot-starter:6.0.1")
```
- [GraphQL CodeGen 추후 적용](https://github.com/kobylynskyi/graphql-java-codegen/tree/master/plugins/gradle)


### 2. Define Schema
1. DB Schema
```sql
create table STORE
(
    id       BIGINT auto_increment,
    name     varchar(150) null,
    status   varchar(20) null,
    city     varchar(100) null,
    state    varchar(100) null,
    zip_code varchar(100) null,
    constraint STORE_pk
        primary key (id)
);
```
2. graphQL API 작성
   1. schema.graphqls
   2. store.graphqls

3. graphQL에서 사용되는 ```input``` 맵핑할 TO 작성
   1. CreateStoreInputTO
   2. UpdateStoreInputTO

```text
graphQL 사용되는 store type은 store model의 맞게
```

4. Resolver 작성 = controller 역할을 한다.
   1. StoreQueryResolver implement **GraphQLQueryResolver**
   2. StoreMutationResolver implement **GraphQLQueryResolver**
```text
Resolver 에선 요청의 맞게 처리
```

5. graphql in query
- findById
```graphql
query {
   storeById(id: 1){
      name # 응답 'store' type의 'name' field 값을 받아온다.
   }
}
```
- create
```graphql
mutation {
    createStore(createStoreInput: {
        storeName: "thrid",
        status: PENDING,
        city : "thrid",
        state : "thrid",
        zipCode : "thrid",
    }) { # 아래는 응답 'store' type field의 값을 받아온다.
        id,
        name,
        status,
        city,
        state,
        zipCode
    }
}
```

### 3.GraphQL에서 제공 되는 스칼라 타입
```text
1. Int: 부호가 있는 32비트 정수
2. Float: 부호가 있는 부동소수점 값 
3. String: UTF-8 문자열 
4. Boolean: true 또는 false 
5. ID: ID 스칼라 타입은 객체를 다시 요청하거나 캐시의 키로써 자주 사용되는 고유 식별자를 나타낸다. ID타입은 String과 같은 방법으로 직렬화되지만, ID로 정의하는 것은 사람이 읽을 수 있도록 하는 의도가 아니라는 것을 의미한다.
```
