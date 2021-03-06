/*
 * Copyright 2011-2012 Brian Matthews
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

import static org.junit.Assert.*;

import com.btmatthews.maven.plugins.emailserver.dumbster.DumbsterMailServer;
import com.btmatthews.maven.plugins.emailserver.dumbster.DumbsterMailServerFactory;
import com.btmatthews.utils.monitor.Server;
import com.btmatthews.utils.monitor.ServerFactory;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test {@link DumbsterMailServerFactory}.
 *
 * @author <a href="mailto:brian@btmatthews.com">Brian Matthews</a>
 * @since 1.0.0
 */
public class TestDumbsterMailServerFactory {

    /**
     * The server factory.
     */
    private ServerFactory serverFactory;

    /**
     * Prepare for the unit test execution by creating the server factory.
     */
    @Before
    public void setUp() {
        serverFactory = new DumbsterMailServerFactory();
    }

    /**
     * Verify that the server factory reports the correct server name.
     */
    @Test
    public void testGetServerName() {
        assertEquals("dumbster", serverFactory.getServerName());
    }

    /**
     * Verify that objects created by the server factory are of the expected
     * type.
     */
    @Test
    public void testCreateServer() {
        final Server server = serverFactory.createServer();
        assertNotNull(server);
        assertTrue(server instanceof DumbsterMailServer);
    }
}
