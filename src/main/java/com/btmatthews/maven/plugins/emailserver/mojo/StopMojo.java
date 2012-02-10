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

package com.btmatthews.maven.plugins.emailserver.mojo;

import org.apache.maven.plugin.Mojo;

import com.btmatthews.utils.monitor.Monitor;

/**
 * Stop the email server(s).
 * 
 * @goal stop
 * 
 * @author <a href="mailto:brian@btmatthews.com">Brian Matthews</a>
 * @since 1.0.0
 */
public class StopMojo extends AbstractServerMojo {

    /**
     * The default constructor.
     */
    public StopMojo() {
    }

    /**
     * Issue a stop command to the monitor in order to shutdown the email
     * server(s).
     * 
     * @see Mojo#execute()
     */
    public void execute() {
	final Monitor monitor = new Monitor(getMonitorKey(), getMonitorPort());
	monitor.sendCommand("stop", this);
    }
}