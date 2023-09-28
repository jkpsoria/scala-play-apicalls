package models.domain

import play.api.libs.json._

case class Coin(name: String, symbol: String, price_usd: String)

object Coin {
  implicit val reads: Reads[Coin] = Json.reads[Coin]
  implicit val format: Format[Coin] = Json.format[Coin]
}