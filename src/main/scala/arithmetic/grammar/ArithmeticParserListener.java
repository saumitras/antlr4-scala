// Generated from ArithmeticParser.g4 by ANTLR 4.6
package arithmetic.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ArithmeticParser}.
 */
public interface ArithmeticParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ArithmeticParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ArithmeticParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArithmeticParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ArithmeticParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArithmeticParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterOperation(ArithmeticParser.OperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArithmeticParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitOperation(ArithmeticParser.OperationContext ctx);
}