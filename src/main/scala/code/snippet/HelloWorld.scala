package code
package snippet

import scala.xml.{NodeSeq, Text}
import net.liftweb.util._
import net.liftweb.common._
import java.util.Date
import code.lib._
import Helpers._
import net.liftweb.http.WiringUI
import net.liftweb.widgets.autocomplete.AutoComplete


class HelloWorld {
  val wiringCell= ValueCell(true)

  /* Methods for new display */

  def displayModules = {
    WiringUI.apply(wiringCell)(displayModulesAjax)
  }

  val cell = ValueCell("")
  def displayModulesAjax(value: Boolean)(ns:NodeSeq):NodeSeq = {
    def buildQueryName(current: String, limit: Int): Seq[String] = {
      if (current.length == 0) Nil
      else (1 to limit).map(n => current+""+n).take(limit)
    }
    AutoComplete("", buildQueryName _, cell.set _ )
  }
}


