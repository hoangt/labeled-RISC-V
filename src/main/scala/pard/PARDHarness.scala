// See LICENSE.SiFive for license details.

package rocketchip

import Chisel._
import diplomacy._
import cde.{Parameters, Field}
import coreplex._
import rocketchip._

//case object BuildPARDFPGATop extends Field[Parameters => PARDFPGATop[coreplex.BaseCoreplex]]

class PARDFPGAHarness(q: Parameters) extends Module {
  val io = new Bundle {
    val success = Bool(OUTPUT)
  }
//  val dut = Module(q(BuildPARDFPGATop)(q).module)
  val dut = Module(LazyModule(new PARDFPGATop(new DefaultCoreplex()(_))(q)).module)
}
