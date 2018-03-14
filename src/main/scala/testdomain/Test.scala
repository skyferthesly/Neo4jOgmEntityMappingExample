package testdomain

import org.neo4j.ogm.session.{Session, SessionFactory}
import org.neo4j.ogm.config.{Configuration, ConfigurationSource, ClasspathConfigurationSource}
import org.neo4j.ogm.annotation.{NodeEntity, Relationship, Id, GeneratedValue, GraphId, Property}

@NodeEntity
class Person {
  @Id
  @Property
  var id: java.lang.Long = _

  @Property
  var firstName: String = _

  @Property
  var lastName: String = _

  def this(firstName: String, lastName: String) {
    this()
    this.firstName = firstName
    this.lastName = lastName
  }
}

object Foo {
  def main(args: Array[String]): Unit = {
    val configuration = new Configuration.Builder(new ClasspathConfigurationSource("ogm.properties")).build()
    val sessionFactory = new SessionFactory(configuration, "testdomain")
    val session = sessionFactory.openSession()

    val me = new Person("The", "Wizard")
    session.save(me)
  }
}

//object Test extends App {
//  val configuration = new Configuration.Builder(new ClasspathConfigurationSource("ogm.properties")).build()
//  val sessionFactory = new SessionFactory(configuration, "testdomain")
//  val session = sessionFactory.openSession()
//
//  val me = new Person("The", "Wizard")
//  session.save(me)
//}