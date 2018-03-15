package testdomain

import org.neo4j.ogm.session.{Session, SessionFactory}
import org.neo4j.ogm.config.{Configuration, ConfigurationSource, ClasspathConfigurationSource}
import org.neo4j.ogm.annotation.{NodeEntity, Relationship, Id, GeneratedValue, GraphId, Property}
import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner

@NodeEntity
class Person {
  @Id
  @GeneratedValue
  var id: java.lang.Long = _
  var firstName: String = _
  var lastName: String = _

  def this(firstName: String, lastName: String) {
    this()
    this.firstName = firstName
    this.lastName = lastName
  }
}

object Foo {
  def main(args: Array[String]): Unit = {
//    val scanner = new FastClasspathScanner("testdomain.Person").scan
//    println(s"length of all scanned classes: ${scanner.getNamesOfAllClasses.size}")
//    println(s"all scanned classes: ${scanner.getNamesOfAllClasses}")

    val configuration = new Configuration.Builder(new ClasspathConfigurationSource("ogm.properties")).build()
    val sessionFactory = new SessionFactory(configuration, "testdomain")
    val session = sessionFactory.openSession()

    val me = new Person("The", "Wizard")
    try{
      session.save(me)
    }
    finally session.clear
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