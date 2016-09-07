package ru.stqa.pft.addressbook.tests;

import org.hibernate.boot.registry.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by irener on 9/6/16.
 */
public class HbConnectionTest {

  @BeforeClass
  protected void setUp() throws Exception {
    // A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
    try {
      sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
    }
    catch (Exception e) {
      // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
      // so destroy it manually.
      StandardServiceRegistryBuilder.destroy( registry );
    }
  }

  @Test
  public void testHbConnection(){

  }
}
