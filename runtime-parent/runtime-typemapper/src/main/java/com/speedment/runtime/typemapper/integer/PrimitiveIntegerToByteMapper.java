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
package com.speedment.runtime.typemapper.integer;

import com.speedment.runtime.config.Column;
import com.speedment.runtime.typemapper.TypeMapper;
import java.lang.reflect.Type;

/**
 * Maps between {@code Integer} and {@code byte} values by simply casting to
 * lower precision.
 * 
 * @author Emil Forslund
 * @since  3.0.2
 */
public final class PrimitiveIntegerToByteMapper implements TypeMapper<Integer, Byte> {

    @Override
    public String getLabel() {
        return "Integer to byte (primitive)";
    }

    @Override
    public Type getJavaType(Column column) {
        return byte.class;
    }

    @Override
    public Byte toJavaType(Column column, Class<?> entityType, Integer value) {
        return value == null ? null : ((byte) (int) value);
    }

    @Override
    public Integer toDatabaseType(Byte value) {
        return value == null ? null : ((int) (byte) value);
    }

    @Override
    public Ordering getOrdering() {
        return Ordering.RETAIN;
    }
    
}