# AWS SDK for JAVA를 사용하여 IAM user 생성하기

```
aws iam create-user --user-name Bob
aws iam create-access-key --user-name Bob 
aws iam add-user-to-group --group-name qraft-data --user-name Bob
```

### Maven 프로젝트 생성
```
mvn archetype:generate \                             
  -DarchetypeGroupId=org.apache.maven.archetypes \
  -DarchetypeArtifactId=maven-archetype-simple \
  -DgroupId=toy.aws \
  -DartifactId=create-aws-user
```

### Maven dependency에 AWS SDK 모듈 추가
`<dependencies>`에 아래를 추가하여 AWS SDK 추가
```
    <dependency>
      <groupId>com.amazonaws</groupId>
      <artifactId>aws-java-sdk-iam</artifactId>
      <version>1.11.1000</version>
    </dependency>
``` 
### Build package
```
mvn package
```