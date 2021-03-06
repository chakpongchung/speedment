/*
 *
 * Copyright (c) 2006-2019, Speedment, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); You may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.speedment.runtime.compute.internal.expression;

import static org.junit.jupiter.api.Assertions.*;

import com.speedment.runtime.compute.ToDouble;
import com.speedment.runtime.compute.expression.UnaryExpression.Operator;
import com.speedment.runtime.compute.internal.expression.SqrtUtil.AbstractSqrt;
import org.junit.jupiter.api.Test;

final class SqrtUtilTest {

    @Test
    void abstractSqrt() {
        final DummySqrt sqrt = new DummySqrt(d -> d);

        assertNotNull(sqrt.inner());
        assertEquals(Operator.SQRT, sqrt.operator());
        assertNotEquals(0, sqrt.hashCode());

        final DummySqrt copy = sqrt;

        assertTrue(sqrt.equals(copy));
        assertFalse(sqrt.equals(null));

        final DummySqrt same = new DummySqrt(sqrt.inner());
        assertTrue(sqrt.equals(same));

        final DummySqrt differentInner = new DummySqrt(d -> d * d);
        assertFalse(sqrt.equals(differentInner));
    }

    private static final class DummySqrt extends AbstractSqrt<Double, ToDouble<Double>> {

        DummySqrt(ToDouble<Double> doubleToDouble) {
            super(doubleToDouble);
        }

        @Override
        public double applyAsDouble(Double object) {
            return 0;
        }
    }

}
