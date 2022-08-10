package scalarecap.sections

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers


trait Section extends App

trait ScalaRecapSection extends AnyFlatSpec with Matchers with Section
