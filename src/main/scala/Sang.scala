package default

import sangria.schema._
import sangria.macros.derive._

import SlickObjects._

object Sang {

  val IdentifiableType = InterfaceType(
    "Identifiable",
    "Entity that can be identified",
    fields[Unit, Identifiable](
      Field("id", IntType, resolve = _.value.id)))

  implicit val PersonType = deriveObjectType[Unit, Person](
    Interfaces(IdentifiableType),
    ObjectTypeDescription("The person"))

  implicit val CompanyType = deriveObjectType[Unit, Company](
    Interfaces(IdentifiableType),
    ObjectTypeDescription("The company"))

  val Id = Argument("id", IntType)

  val QueryType = ObjectType("Query", fields[DatabaseAccess, Unit](
    Field("person", OptionType(PersonType),
      description = Some("Returns a person"),
      arguments = Id :: Nil,
      resolve = c => c.ctx.person(c arg Id)),
    Field("persons", ListType(PersonType),
      description = Some("Returns a list of all available persons."),
      resolve = _.ctx.persons)))

  val schema = Schema(QueryType)

}

