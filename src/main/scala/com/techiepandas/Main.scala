package com.techiepandas

case class ScalaParserBag(s: String) {
}

import java.nio.file._

class ScalaParser(path: String){
	val pathToData = Paths.get(path)
  val bufferedSource = io.Source.fromURL(pathToData.toUri().toURL())

  def parseLines(): Unit = {
    for(line <- bufferedSource.getLines()){
      val cols = line.split(",").map(_.trim)
      println(s"${cols(0)}|${cols(2)}|${cols(3)}")
    }
  }
}

object Start {
  def main(args: Array[String]): Unit = {
    val scalaParser = new ScalaParser("/Users/rajesh/Downloads/melbourne_waste_collection.csv")
    scalaParser.parseLines()
  }
}