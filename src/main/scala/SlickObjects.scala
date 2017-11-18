package default

import slick.driver.SQLiteDriver.api._

object SlickObjects {

  trait Identifiable {
    def id: Int
  }

  case class Person(id: Int, name: String, age: Int) extends Identifiable
  case class Company(id: Int, name: Option[String], address: Option[String]) extends Identifiable
  case class Employment(id: Int, personId: Int, companyId: Int) extends Identifiable

  case class PersonTable(tag: Tag) extends Table[Person](tag, "person") {
    def id = column[Int]("ID", O.PrimaryKey, O.AutoInc)
    def name = column[String]("NAME")
    def age = column[Int]("AGE")
    def * = (id, name, age) <> (Person.tupled, Person.unapply)
  }

  case class CompanyTable(tag: Tag) extends Table[Company](tag, "company") {
    def id = column[Int]("ID", O.PrimaryKey, O.AutoInc)
    def name = column[Option[String]]("NAME")
    def address = column[Option[String]]("ADDRESS")
    def * = (id, name, address) <> (Company.tupled, Company.unapply)
  }

  case class EmploymentTable(tag: Tag) extends Table[Employment](tag, "employment") {
    def id = column[Int]("ID")
    def personId = column[Int]("PERSON_ID")
    def companyId = column[Int]("COMPANY_ID")
    def * = (id, personId, companyId) <> (Employment.tupled, Employment.unapply)
  }
}

