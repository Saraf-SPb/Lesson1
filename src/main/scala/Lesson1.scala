import io.circe.generic.auto._
import io.circe.parser.decode
import io.circe.syntax._
import model._

import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Paths}
import scala.io.Source
import scala.language.implicitConversions

object Lesson1 extends App {
  var fileName = "output.json"
  val continent = "Africa"
  if (args.length > 0)
    fileName = args(0)

  val source = Source.fromURL("https://raw.githubusercontent.com/mledoze/countries/master/countries.json").mkString
  val value = decode[List[Country]](source)

  value match {
    case Right(value) =>
      val result = value
        .filter(x => x.region.contains(continent) && x.capital.nonEmpty)
        .map(x =>
          TargetCountry(
            name = x.name.official,
            capital = x.capital.head,
            area = x.area
          ))
        .sortBy(x => x.area)
        .reverse
        .take(10)
        .asJson
        .noSpaces
      Files.write(Paths.get(fileName), result.getBytes(StandardCharsets.UTF_8))
      println("Result was save in " + fileName)
    case Left(value) => throw new RuntimeException(s"Parsing error $value")
  }
}
