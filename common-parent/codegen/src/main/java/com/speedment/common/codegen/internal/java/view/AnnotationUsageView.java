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
package com.speedment.common.codegen.internal.java.view;

import com.speedment.common.codegen.Generator;
import com.speedment.common.codegen.Transform;
import com.speedment.common.codegen.model.AnnotationUsage;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

import static com.speedment.common.codegen.util.CollectorUtil.joinIfNotEmpty;
import static java.util.Objects.requireNonNull;

/**
 * Transforms from an {@link AnnotationUsage} to java code.
 *
 * @author Emil Forslund
 */
public final class AnnotationUsageView implements Transform<AnnotationUsage, String> {

    @Override
    public Optional<String> transform(Generator gen, AnnotationUsage model) {
        requireNonNull(gen);
        requireNonNull(model);

        final Optional<String> value = gen.on(model.getValue());
        final Stream<String> valueStream = value.map(Stream::of).orElseGet(Stream::empty);

        return Optional.of(
                "@" + gen.on(model.getType()).orElseThrow(NoSuchElementException::new)
                + Stream.of(
                    model.getValues().stream()
                        .map(e -> e.getKey() + 
                            gen.on(e.getValue())
                                .map(s -> " = " + s)
                                .orElse("")
                        ),
                    valueStream
                ).flatMap(s -> s).collect(
                joinIfNotEmpty(", ", "(", ")")
        )
        );
    }
}
