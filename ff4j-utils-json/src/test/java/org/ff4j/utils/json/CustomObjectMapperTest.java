package org.ff4j.utils.json;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
 * #%L
 * ff4j-utils-json
 * %%
 * Copyright (C) 2013 - 2016 FF4J
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

/**
 * Improve coverage.
 *
 * @author Cedrick LUNVEN (@clunven
 */
public class CustomObjectMapperTest {
    
    @Test
    public void init() {
        Assertions.assertNotNull(new FF4jCustomObjectMapper ()); 
    }

}
