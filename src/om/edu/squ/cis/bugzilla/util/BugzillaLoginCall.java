/**
 * Project				:	prjBugzillaJavaIntegration
 * Organization			:	Sultan Qaboos University | Muscat | Oman
 * Centre				:	Centre for Information System
 * Department			:	Planning & Development
 * 
 * Author				:	Bhabesh
 *
 * FrameWork/Tech		:	Java
 * 
 * File Name			:	BugzillaLoginCall.java
 * Package Name			:	om.edu.squ.cis.bugzilla.util
 * Date of creation		:	Aug 14, 2011  10:20:54 AM
 * Date of modification :	
 * 
 * Summary				:	
 *
 *
 * Copyright 2011 the original author or authors and Organization.
 *
 * Licensed under the SQU, CIS policy
 * you may not use this file except in compliance with the License.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * 
 */
package om.edu.squ.cis.bugzilla.util;

import java.io.FileInputStream;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.xmlrpc.XmlRpcException;

/**
 * @author Bhabesh
 *
 */
public class BugzillaLoginCall extends BugzillaAbstractRPCCall
{

	private	static BugzillaLoginCall bugzillaLoginCall;	
    /**
     * Create a Bugzilla login call instance and set parameters
     */
    private BugzillaLoginCall() {
        //super("User.login");
    	super();
    	setCommand("User.login");
        setParameter("login", BugProperty.getProperty("bug.bugzilla.portal.username"));
        setParameter("password", BugProperty.getProperty("bug.bugzilla.portal.password"));
    }

    /**
     * Perform the login action and set the login cookies
     * @returns True if login is successful, false otherwise. The method sets Bugzilla login cookies.
     */
    public static synchronized boolean login() {
        Map result = null;
        try {
        	if(null==bugzillaLoginCall)
        	{
        		bugzillaLoginCall	=	new BugzillaLoginCall();
        	}
            // the result should contain one item with ID of logged in user
        	
            result = bugzillaLoginCall.execute();
        } catch (XmlRpcException ex) {
            Logger.getLogger(BugzillaLoginCall.class.getName()).log(Level.SEVERE, null, ex);
        }
        return !(result == null || result.isEmpty());
    }

}