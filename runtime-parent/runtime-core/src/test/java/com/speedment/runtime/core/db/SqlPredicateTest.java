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

package com.speedment.runtime.core.db;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.sql.SQLException;
import java.util.Objects;
import java.util.function.Predicate;

final class SqlPredicateTest {

    @ParameterizedTest
    @ValueSource(strings = {"test", ""})
    void wrap(String input) throws SQLException {
        Assertions.assertThrows(NullPointerException.class, () -> SqlPredicate.wrap(null));

        Predicate<String> predicate = string -> string != null && !string.isEmpty();
        SqlPredicate<String> sqlPredicate = SqlPredicate.wrap(predicate);

        assertNotNull(sqlPredicate);
        assertEquals(predicate.test(input), sqlPredicate.test(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"test", ""})
    void unWrap(String input) throws SQLException {
        SqlPredicate<String> sqlPredicate = string -> string != null && !string.isEmpty();
        Predicate<String> predicate = sqlPredicate.unWrap();

        assertNotNull(predicate);
        assertEquals(sqlPredicate.test(input), predicate.test(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"test"})
    void and(String input) throws SQLException {
        SqlPredicate<String> first = Objects::nonNull;
        SqlPredicate<String> second = string -> !string.isEmpty();

        assertThrows(NullPointerException.class, () -> first.and(null));

        SqlPredicate<String> sqlPredicate = first.and(second);

        assertTrue(sqlPredicate.test(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"test"})
    void negate(String input) throws SQLException {
        SqlPredicate<String> sqlPredicate = string -> string != null && !string.isEmpty();

        assertTrue(sqlPredicate.test(input));

        SqlPredicate<String> negatedSqlPredicate = sqlPredicate.negate();

        assertFalse(negatedSqlPredicate.test(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {""})
    void or(String input) throws SQLException {
        SqlPredicate<String> first = Objects::isNull;
        Predicate<String> second = String::isEmpty;

        assertThrows(NullPointerException.class, () -> first.or(null));

        SqlPredicate<String> sqlPredicate = first.or(second);

        assertTrue(sqlPredicate.test(input));
    }
}
