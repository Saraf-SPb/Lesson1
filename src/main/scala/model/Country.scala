package model

case class Country(
                    region: Option[String],
                    area: Double,
                    capital: List[String],
                    name: Name
                  )
