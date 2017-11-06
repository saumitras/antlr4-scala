package arithmetic

import arithmetic.grammar._
import org.antlr.v4.runtime._
import scala.util.Try

import scala.collection.JavaConversions._

object ArithmeticVisitorTest extends App {

  sealed trait Expr
  case class Operation(name:String) extends Expr
  case class ExprResult(res:Option[Double]) extends Expr

  val expressions = List(
    "127.1 + 2717",
    "2674 - 4735",
    "47 * 74.1",
    "271 / 281",
    "12 ^ 3"
  )
  expressions.foreach(parse)


  def parse(input:String) = {
    println("\nEvaluating expression " + input)

    val charStream = new ANTLRInputStream(input)
    val lexer = new ArithmeticLexer(charStream)
    val tokens = new CommonTokenStream(lexer)
    val parser = new ArithmeticParser(tokens)

    val arithmeticVisitor = new ArithmeticVisitorApp()
    val res = arithmeticVisitor.visit(parser.expr())
    println(res)

  }



  class ArithmeticVisitorApp extends ArithmeticParserBaseVisitor[Expr] {

    override def visitExpr(ctx: ArithmeticParser.ExprContext): ExprResult = {
      val exprText = ctx.getText
      println(s"Expression after tokenization = $exprText")

      val operands = ctx.NUMBER().toList.map(_.getText)
      val operand1 = parseDouble(operands.lift(0).getOrElse("0.0")).getOrElse(0.0)
      val operand2 = parseDouble(operands.lift(1).getOrElse("0.0")).getOrElse(0.0)

      val operation = visitOperation(ctx.operation())

      ExprResult(calculate(operand1, operand2, operation.name))

    }


    override def visitOperation(ctx: ArithmeticParser.OperationContext): Operation = {
      val op = ctx.getText
      Operation(op)
    }

    def parseDouble(s: String): Option[Double] = Try(s.toDouble).toOption

    def calculate(op1:Double, op2:Double, operation:String):Option[Double] = {
      operation match {
        case "+" => Some(op1 + op2)
        case "-" => Some(op1 - op2)
        case "*" => Some(op1 * op2)
        case "/" => Try(op1 / op2).toOption

        case _ =>
          println(s"Unsupported operation")
          None
      }

    }

  }


}
