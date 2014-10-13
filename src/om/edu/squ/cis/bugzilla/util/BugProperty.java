/**
 * Project				:	prjBugzillaJavaIntegration
 * Organization			:	Sultan Qaboos University | Muscat | Oman
 * Centre				:	Centre for Information System
 * Department			:	Planning & Development
 * 
 * Author				:	Bhabesh
 *
 * FrameWork			:	Spring 2.5 (Annotation) Portlet
 * 
 * File Name			:	BugProperty.java
 * Package Name			:	om.edu.squ.cis.bugzilla.util
 * Date of creation		:	Aug 15, 2011  10:51:15 AM
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

import java.util.Properties;

/**
 * @author Bhabesh
 *
 */
public class BugProperty
{
	private static BugProperty	bugProperty;
	private	static	Properties 	propFile;
	private BugProperty()
	{

					propFile	= 	new Properties();

		try
		{
			propFile.load(this.getClass().getResourceAsStream("/bug.properties"));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		
	}
	
	
	public static synchronized String getProperty(String property)
	{
		
		if(null==bugProperty)
		{
			bugProperty	=	new BugProperty();
		}
		
		return propFile.getProperty(property);
		
	}
	
/*	
	public static void main(String args[])
	{
		
		System.out.println("getProp : "+BugProperty.getProperty("bug.bugzilla.portal.username"));
	}
*/	
}
