package default

import org.sqlite.JDBC
import slick.driver.SQLiteDriver.api._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

import SlickObjects._

class DatabaseAccess {
  
  val personTable = TableQuery[PersonTable]
  val companyTable = TableQuery[CompanyTable]
  val employmentTable = TableQuery[EmploymentTable]

  val db = Database.forURL("jdbc:sqlite:./employment.db")

  def persons: Future[Seq[Person]] = {
    db.run(personTable.result)
  }

  def person(id: Int): Future[Option[Person]] = {
    db.run( personTable.filter(_.id === id).result.headOption)
  } 
}

