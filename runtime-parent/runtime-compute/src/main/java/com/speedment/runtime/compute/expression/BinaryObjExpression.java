package com.speedment.runtime.compute.expression;

/**
 * An {@link Expression} that has two operands, one is another
 * {@link Expression} and the other is a primitive {@code int}.
 * <p>
 * Equality is determined by looking at {@link #getFirst()},
 * {@link #getSecond()} and {@link #getOperator()}.
 *
 * @param <T>      the input entity type
 * @param <FIRST>  the type of the first operand, an expression
 * @param <V>      the type of the second operand, a constant value
 *
 * @author Emil Forslund
 * @since  3.1.0
 */
public interface BinaryObjExpression<T, FIRST extends Expression<T>, V>
extends Expression<T> {

    /**
     * Returns the first operand, an inner expression.
     *
     * @return  the first operand
     */
    FIRST getFirst();

    /**
     * Returns the second operand, a constant value.
     *
     * @return  the second operand
     */
    V getSecond();

    /**
     * Returns the binary operator that this expression represents.
     *
     * @return  the operator
     */
    Operator getOperator();

    /**
     * Operator types that could be returned by {@link #getOperator()}.
     */
    enum Operator {
        /**
         * The result of the first operand raised to the power of the second.
         */
        POW,

        /**
         * The result of the first operand added to the second (addition).
         */
        PLUS,

        /**
         * The result of the first operand minus the second (subtraction).
         */
        MINUS,

        /**
         * The result of the first operand multiplied by the second
         * (multiplication).
         */
        MULTIPLY,

        /**
         * The result of the first operand divided by the second (division).
         */
        DIVIDE
    }
}