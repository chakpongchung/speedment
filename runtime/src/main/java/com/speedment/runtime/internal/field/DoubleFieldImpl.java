package com.speedment.runtime.internal.field;

import com.speedment.runtime.config.identifier.FieldIdentifier;
import com.speedment.runtime.config.mapper.TypeMapper;
import com.speedment.runtime.field.DoubleField;
import com.speedment.runtime.field.method.DoubleGetter;
import com.speedment.runtime.field.method.DoubleSetter;
import com.speedment.runtime.field.predicate.FieldPredicate;
import com.speedment.runtime.field.predicate.Inclusion;
import com.speedment.runtime.internal.field.comparator.DoubleFieldComparator;
import com.speedment.runtime.internal.field.comparator.DoubleFieldComparatorImpl;
import com.speedment.runtime.internal.field.predicate.doubles.DoubleBetweenPredicate;
import com.speedment.runtime.internal.field.predicate.doubles.DoubleEqualPredicate;
import com.speedment.runtime.internal.field.predicate.doubles.DoubleGreaterOrEqualPredicate;
import com.speedment.runtime.internal.field.predicate.doubles.DoubleGreaterThanPredicate;
import com.speedment.runtime.internal.field.predicate.doubles.DoubleInPredicate;
import java.util.Set;
import java.util.function.Predicate;
import static java.util.Objects.requireNonNull;

/**
 * @param <ENTITY> entity type
 * @param <D>      database type
 * 
 * @author Emil Forslund
 * @since  3.0.0
 */
public final class DoubleFieldImpl<ENTITY, D>  implements DoubleField<ENTITY, D> {
    
    private final FieldIdentifier<ENTITY> identifier;
    private final DoubleGetter<ENTITY> getter;
    private final DoubleSetter<ENTITY> setter;
    private final TypeMapper<D, Double> typeMapper;
    private final boolean unique;
    
    public DoubleFieldImpl(FieldIdentifier<ENTITY> identifier, DoubleGetter<ENTITY> getter, DoubleSetter<ENTITY> setter, TypeMapper<D, Double> typeMapper, boolean unique) {
        this.identifier = requireNonNull(identifier);
        this.getter     = requireNonNull(getter);
        this.setter     = requireNonNull(setter);
        this.typeMapper = requireNonNull(typeMapper);
        this.unique     = unique;
    }
    
    @Override
    public FieldIdentifier<ENTITY> identifier() {
        return identifier;
    }
    
    @Override
    public DoubleSetter<ENTITY> setter() {
        return setter;
    }
    
    @Override
    public DoubleGetter<ENTITY> getter() {
        return getter;
    }
    
    @Override
    public TypeMapper<D, Double> typeMapper() {
        return typeMapper;
    }
    
    @Override
    public boolean isUnique() {
        return unique;
    }
    
    @Override
    public DoubleFieldComparator<ENTITY, D> comparator() {
        return new DoubleFieldComparatorImpl<>(this);
    }
    
    @Override
    public DoubleFieldComparator<ENTITY, D> comparatorNullFieldsFirst() {
        return comparator();
    }
    
    @Override
    public DoubleFieldComparator<ENTITY, D> comparatorNullFieldsLast() {
        return comparator();
    }
    
    @Override
    public FieldPredicate<ENTITY> equal(Double value) {
        return new DoubleEqualPredicate<>(this, value);
    }
    
    @Override
    public FieldPredicate<ENTITY> greaterThan(Double value) {
        return new DoubleGreaterThanPredicate<>(this, value);
    }
    
    @Override
    public FieldPredicate<ENTITY> greaterOrEqual(Double value) {
        return new DoubleGreaterOrEqualPredicate<>(this, value);
    }
    
    @Override
    public FieldPredicate<ENTITY> between(Double start, Double end, Inclusion inclusion) {
        return new DoubleBetweenPredicate<>(this, start, end, inclusion);
    }
    
    @Override
    public FieldPredicate<ENTITY> in(Set<Double> set) {
        return new DoubleInPredicate<>(this, set);
    }
    
    @Override
    public Predicate<ENTITY> notEqual(Double value) {
        return new DoubleEqualPredicate<>(this, value).negate();
    }
    
    @Override
    public Predicate<ENTITY> lessOrEqual(Double value) {
        return new DoubleGreaterThanPredicate<>(this, value).negate();
    }
    
    @Override
    public Predicate<ENTITY> lessThan(Double value) {
        return new DoubleGreaterOrEqualPredicate<>(this, value).negate();
    }
    
    @Override
    public Predicate<ENTITY> notBetween(Double start, Double end, Inclusion inclusion) {
        return new DoubleBetweenPredicate<>(this, start, end, inclusion).negate();
    }
    
    @Override
    public Predicate<ENTITY> notIn(Set<Double> set) {
        return new DoubleInPredicate<>(this, set).negate();
    }
}