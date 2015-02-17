package controllers

import models.Item
import models.Chat

import org.joda.time.LocalTime
import org.joda.time.Days
import org.joda.time.DateTime
import play.api._
import play.api.mvc._

object Application extends Controller {
  def index = Action {
    val today = DateTime.now
    val yesterday = today.minus(Days.ONE)

    val chat11 = Chat(yesterday, 1, Seq(
      Item("me", LocalTime.now(), "Hello!"),
      Item("other", LocalTime.now(), "Hi!"),
      Item("me", LocalTime.now(), "Fine?"),
      Item("other", LocalTime.now(), "Yes")
    ))

    val chat12 = Chat(yesterday, 2, Seq(
      Item("me", LocalTime.now(), "It's hot today!"),
      Item("other", LocalTime.now(), "Indeed...")
    ))

    val chat21 = Chat(today, 1, Seq(
      Item("me", LocalTime.now(), "Hello!"),
      Item("me", LocalTime.now(), "Youhou?"),
      Item("no-one", LocalTime.now(), "...")
    ))
    val chat22 = Chat(today, 2, Seq(
      Item("me", LocalTime.now(), "Ding ding!"),
      Item("me", LocalTime.now(), "Poueeeeeeeeeet?"),
      Item("no-one", LocalTime.now(), "...")
    ))

    val chat23 = Chat(today, 3, Seq(
      Item("me", LocalTime.now(), "No one?"),
      Item("no-one", LocalTime.now(), "Yes?")
    ))

    Ok(views.html.index("Chat Archives")(Seq(
      chat23,
      chat11,
      chat21,
      chat12,
      chat22
    ))
    )
  }
}
