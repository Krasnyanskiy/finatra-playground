package il.goldberg.finatra.playground.web

/**
  * @author Arri Goldberg
  */
package object controller {

  implicit def str2Printable(s: String): PrintableString = PrintableString(s)

  case class PrintableString(s: String) {
    def toStdout(): Unit = {
      println(s"[$s]")
    }
  }

}
