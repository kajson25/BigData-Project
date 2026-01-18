package com

import scalaj.http.{Http, HttpOptions}

import java.io.{BufferedWriter, FileWriter}
import scala.io.Source
import scala.util.control.Breaks._

object UdemyProducer extends App {

  val streamUrl = "http://localhost:5000/stream/type1"
  val outputFilePath = "udemy_courses.json"

  println(s"Povezivanje na stream: $streamUrl")
  println(s"Podaci će biti sačuvani u: $outputFilePath")

  val writer = new BufferedWriter(new FileWriter(outputFilePath))

  try {
    Http(streamUrl)
      .option(HttpOptions.readTimeout(0))
      .execute { inputStream =>
        val lines = Source.fromInputStream(inputStream).getLines()
        for (line <- lines) {
          if (line.trim.equalsIgnoreCase("close")) {
            println("Primljena 'close' poruka. Završavam.")
            break()
          }
          writer.write(line)
          writer.newLine()
        }
      }
  } catch {
    case e: Exception => e.printStackTrace()
  } finally {
    writer.close()
  }
  println("Snimanje podataka u fajl je završeno.")
}