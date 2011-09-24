/*
 * Copyright 2011 Brian Matthews
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

package com.btmatthews.maven.plugins.greenmail.mojo;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

/**
 * Run the GreenMail mail servers.
 * 
 * @goal run
 * @execute phase="test-compile"
 * 
 * @author <a href="mailto:brian@btmatthews.com">Brian Matthews</a>
 * @since 1.0.0
 */
public class RunMojo extends AbstractServerMojo {

	/**
	 * @parameter expression="${greenmail.daemon}" default-value="false"
	 */
	private boolean daemon;

	/**
	 * The default constructor.
	 */
	public RunMojo() {
	}

	/**
	 * Execute the Mojo by launching the GreenMail server and waiting for the
	 * stop command.
	 * 
	 * @throws MojoExecutionException
	 * @throws MojoFailureExeption
	 */
	public void execute() throws MojoExecutionException, MojoFailureException {
		final Monitor monitor = new Monitor(getMonitorKey(), getMonitorPort());
		final Server server = new GreenMailServer();
		server.start(this);
		if (daemon) {
			new Thread(new Runnable() {
				public void run() {
					monitor.runMonitor(server, RunMojo.this);
				}
			}).start();
		} else {
			monitor.runMonitor(server, this);
		}
	}
}