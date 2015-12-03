package il.goldberg.finatra.playground

import il.goldberg.finatra.playground.controller.PrintableString

/**
  * @author Alexander Krasniansky
  */
package object controller {

  implicit def str2Printable(s: String): PrintableString = PrintableString(s)

  case class PrintableString(s: String) {
    def toStdout(): Unit = {
      println(s"[$s]")
    }
  }

}
