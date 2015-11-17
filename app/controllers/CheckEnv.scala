package controllers


//import com.google.inject.Singleton

import com.google.inject.Singleton
import com.typesafe.config.ConfigFactory
import dao.PostDao
import model.{ProviderContext, CustomizeContext}

import play.api.mvc.{Action, Controller}

@Singleton
class CheckEnv extends Controller  with ProviderContext {
  val config = ConfigFactory.load()

  var currentCount = 0

  def check() = Action {
    currentCount += 1
    Ok(s"current env ${config.getString("env.debug")} : $currentCount")
  }


  def show(id: Long) = Action { implicit request =>
    Ok(views.html.sem_test_2(PostDao.queryPostById(id).head))
  }

}