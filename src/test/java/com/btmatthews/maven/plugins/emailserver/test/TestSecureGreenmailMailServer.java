/*
 * Copyright 2011-2013 Brian Matthews
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.btmatthews.maven.plugins.emailserver.test;

import com.btmatthews.maven.plugins.emailserver.greenmail.GreenmailMailServer;

/**
 * Unit test {@link GreenmailMailServer}.
 *
 * @author <a href="mailto:brian@btmatthews.com">Brian Matthews</a>
 * @since 1.0.0
 */
public class TestSecureGreenmailMailServer extends AbstractMailServerTest {

    /**
     * Configure the test for the {@link GreenmailMailServer} without a port
     * offset and using SMTPS.
     */
    public TestSecureGreenmailMailServer() {
        super(new GreenmailMailServer(), 10000, true, null);
    }
}
