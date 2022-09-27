Naming server yada service registry

Bir service registry oluşturmak için yaptığım tek şey pom a gerekli dependency eklemek.
<artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>

Eurekayı kullanabilmek için application classında da @EnableEurekaServer anotasyonunu kullandım.

Konfigurasyon olarak lokal projelerimi register edebilmek için ilgili ayarları setledim.
eureka:
  client:
    register-with-eureka: false
    fetch-registry: false
