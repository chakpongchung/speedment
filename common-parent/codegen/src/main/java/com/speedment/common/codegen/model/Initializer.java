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
package com.speedment.common.codegen.model;

import com.speedment.common.codegen.internal.model.InitializerImpl;
import com.speedment.common.codegen.model.modifier.InitalizerModifier;
import com.speedment.common.codegen.model.trait.HasCall;
import com.speedment.common.codegen.model.trait.HasCode;
import com.speedment.common.codegen.model.trait.HasCopy;
import com.speedment.common.codegen.model.trait.HasImports;
import com.speedment.common.codegen.model.trait.HasInitializers;
import com.speedment.common.codegen.model.trait.HasParent;

/**
 * A model that represents an initializer in code.
 * 
 * @author Emil Forslund
 * @since  2.1
 */
public interface Initializer
extends HasParent<HasInitializers<?>, Initializer>,
        HasImports<Initializer>,
        HasCopy<Initializer>,
        HasCall<Initializer>,
        HasCode<Initializer>,
        InitalizerModifier<Initializer> {

    /**
     * Creates a new instance implementing this interface by using the default
     * implementation.

     * @return  the new instance
     */
    static Initializer of() {
        return new InitializerImpl();
    }
}