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

package com.btmatthews.maven.plugins.emailserver.dumbster;

import com.btmatthews.utils.monitor.Logger;
import com.btmatthews.utils.monitor.Server;
import com.dumbster.smtp.SimpleSmtpServer;

/**
 * Encapsulates the Dumbster fake SMTP server allowing it to be controlled by a
 * monitor.
 * 
 * @author <a href="mailto:brian@btmatthews.com">Brian Matthews</a>
 * @since 1.0.0
 */
public class DumbsterMailServer implements Server {

    /**
     * Used to control the Dumbster fake SMTP server.
     */
    private SimpleSmtpServer server;

    /**
     * Start the GreenMail mail servers.
     */
    public void start(final Logger logger) {
	logger.logInfo("Starting Dumbster fake SMTP server...");
	server = SimpleSmtpServer.start();
	logger.logInfo("Started Dumbster fake SMTP server");
    }

    /**
     * Stop the GreenMail mail servers.
     */
    public void stop(final Logger logger) {
	logger.logInfo("Stopping Dumbster fake SMTP server...");
	if (server != null) {
	    server.stop();
	}
	logger.logInfo("Stopped Dumbster fake SMTP server");
    }
}
