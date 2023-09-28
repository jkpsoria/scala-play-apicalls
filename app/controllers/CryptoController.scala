package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.ws._
import scala.concurrent.{ExecutionContext, Future}
import models.domain._
import models.domain.Coin

case class Coin(id: String, symbol: String, name: String)

@Singleton
class CryptoController @Inject()(ws: WSClient, cc: ControllerComponents)(implicit ec: ExecutionContext) extends AbstractController(cc) {

  def getBitcoinPrice = Action.async { implicit request: Request[AnyContent] =>
    
    val apiKey = "2BD826C3-8D0E-4E08-BF11-76FB1E8F7ACF" // Replace with your CoinAPI API key
    val coinAPIUrl = "https://rest.coinapi.io/v1/exchangerate/BTC/USD?apiKey=2BD826C3-8D0E-4E08-BF11-76FB1E8F7ACF"

    ws.url(coinAPIUrl).get().map { response =>
      if (response.status == 200) {
        val bitcoinPrice = (response.json \ "rate").as[Double]
        Ok(views.html.bitcoinPrice(bitcoinPrice))
      } else {
        InternalServerError("Failed to fetch Bitcoin price")
      }
    }
  }


    def getEtheriumPrice = Action.async { implicit request: Request[AnyContent] =>
    
        val apiKey = "2BD826C3-8D0E-4E08-BF11-76FB1E8F7ACF" // Replace with your CoinAPI API key
        val coinAPIUrl = "https://rest.coinapi.io/v1/exchangerate/ETH/USD?apiKey=2BD826C3-8D0E-4E08-BF11-76FB1E8F7ACF"

        ws.url(coinAPIUrl).get().map { response =>
        if (response.status == 200) {
            val etheriumPrice = (response.json \ "rate").as[Double]
            Ok(views.html.etheriumPrice(etheriumPrice))
        } else {
            InternalServerError("Failed to fetch Etherium price")
        }
        }
    }

    import play.api.libs.json._

    // implicit val seqCoinReads: Reads[Seq[Coin]] = Reads.seq(Coin.coinFormat)
 

   

    // def getTop10Cryptocurrencies: Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
        
    //     implicit val seqCoinReads: Reads[Seq[Coin]] = Reads.seq(Coin.coinFormat)
    //     val apiKey = "2BD826C3-8D0E-4E08-BF11-76FB1E8F7ACF" // Replace with your CoinAPI API key
    //     val coinAPIUrl = "https://rest.coinapi.io/v1/exchangerate/?limit=10&apiKey=2BD826C3-8D0E-4E08-BF11-76FB1E8F7ACF"

    //     ws.url(coinAPIUrl).get().map { response =>
    //     if (response.status == 200) {
    //         val cryptocurrencies = (response.json \ "data").as[Seq[Coin]]
    //         Ok(views.html.index(cryptocurrencies))
    //     } else {
    //         InternalServerError("Failed to fetch cryptocurrency prices")
    //     }
    //     }
    // }

}
