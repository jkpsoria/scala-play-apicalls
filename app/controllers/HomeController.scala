package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import scala.concurrent.Future
import models.domain._
import play.api.libs.json._
import play.api.libs.ws.WSClient
import scala.concurrent.ExecutionContext
import java.lang.ProcessBuilder.Redirect
/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(ws: WSClient, val controllerComponents: ControllerComponents, implicit val ec: ExecutionContext) extends BaseController {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action { implicit request: Request[AnyContent] =>
    Redirect(routes.HomeController.getPokemonNames)
  }

  

  def getPokemonNames = Action.async { implicit request: Request[AnyContent] =>
    val pokeAPIUrl = "https://pokeapi.co/api/v2/pokemon"

    ws.url(pokeAPIUrl).get().map { response =>
      if (response.status == 200) {
        val pokemonNames = (response.json \ "results").as[List[JsValue]].map(p => (p \ "name").as[String])
        Ok(views.html.index(pokemonNames))
      } else {
        InternalServerError("Failed to fetch Pokemon data")
      }
    }
  }





}
