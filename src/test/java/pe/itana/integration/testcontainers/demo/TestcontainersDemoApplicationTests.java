package pe.itana.integration.testcontainers.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.OracleContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class TestcontainersDemoApplicationTests {
  
  @Container
  public static OracleContainer oracleContainer = new OracleContainer()
    .withPassword("secreto")
    .withUsername("system");
  
  @DynamicPropertySource
  static void oracleProperties(DynamicPropertyRegistry registry) {
    System.out.println(oracleContainer.getJdbcUrl());
    System.out.println(oracleContainer.getPassword());
    System.out.println(oracleContainer.getUsername());
    registry.add("spring.datasource.url", oracleContainer::getJdbcUrl);
    registry.add("spring.datasource.password", oracleContainer::getPassword);
    registry.add("spring.datasource.username", oracleContainer::getUsername);
  }
  
  @Test
  void test01() {
    assertEquals("uno", "uno");
  }
  
  @Test
	void contextLoads() {
	}

}
