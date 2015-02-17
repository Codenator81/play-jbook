package models

/**
 * Created by Alex on 15-Feb-15.
 */

import org.joda.time.DateTime

case class Chat (date:DateTime, occurrence:Int, items:Seq[Item])
