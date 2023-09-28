// import play.api.libs.json.{JsValue, Json}
// import play.api.libs.ws.{WSClient, WSRequest}
// import scala.concurrent.Future

// class CoinAPI(ws: WSClient) {

//   def fetchCryptocurrencies: Future[JsValue] = {
//     val request: WSRequest = ws.url("https://rest.coinapi.io/v3/assets")
//     request.get()
//   }
// }