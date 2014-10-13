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
 * File Name			:	BugData.java
 * Package Name			:	om.edu.squ.cis.bugzilla.bo
 * Date of creation		:	Aug 21, 2011  12:46:42 PM
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
package om.edu.squ.cis.bugzilla.bo;

import java.util.List;

/**
 * @author Bhabesh
 *
 */
public class BugData
{
	private	String				bugId;
	private	String				bugSummary;
	private	String				bugStatus;
	private	String				bugOpenClose;
	private	List<BugComments>	bugComments;
	
	
	public BugData(){}
	
	public BugData(String paramBugId, String paramBugSummary, List<BugComments> paramBugComments)
	{
		this.bugId			=	paramBugId;
		this.bugSummary		=	paramBugSummary;
		this.bugComments	=	paramBugComments;
	}
	

	public BugData(String paramBugId, String paramBugSummary)
	{
		this.bugId			=	paramBugId;
		this.bugSummary		=	paramBugSummary;
	}
	
	public BugData(String paramBugId, String paramBugSummary, String paramBugStatus,String paramBugOpenClose)
	{
		this.bugId			=	paramBugId;
		this.bugSummary		=	paramBugSummary;
		this.bugStatus		=	paramBugStatus;
		this.bugOpenClose	=	paramBugOpenClose;
	}
	
	/**
	 * Getter Method	: getBugId
	 * @return the bugId
	 * 
	 * Date				: Aug 21, 2011
	 */
	public String getBugId()
	{
		return this.bugId;
	}
	/**
	 * Setter method : setBugId
	 * @param bugId the bugId to set
	 * 
	 * Date          : Aug 21, 2011 12:52:12 PM
	 */
	public void setBugId(String bugId)
	{
		this.bugId = bugId;
	}
	/**
	 * Getter Method	: getBugSummary
	 * @return the bugSummary
	 * 
	 * Date				: Aug 21, 2011
	 */
	public String getBugSummary()
	{
		return this.bugSummary;
	}
	/**
	 * Setter method : setBugSummary
	 * @param bugSummary the bugSummary to set
	 * 
	 * Date          : Aug 21, 2011 12:52:12 PM
	 */
	public void setBugSummary(String bugSummary)
	{
		this.bugSummary = bugSummary;
	}
	/**
	 * Getter Method	: getBugStatus
	 * @return the bugStatus
	 * 
	 * Date				: Dec 18, 2011
	 */
	public String getBugStatus()
	{
		return this.bugStatus;
	}
	/**
	 * Setter method : setBugStatus
	 * @param bugStatus the bugStatus to set
	 * 
	 * Date          : Dec 18, 2011 10:05:50 AM
	 */
	public void setBugStatus(String bugStatus)
	{
		this.bugStatus = bugStatus;
	}

	/**
	 * Getter Method	: getBugOpenClose
	 * @return the openClose
	 * 
	 * Date				: Dec 18, 2011
	 */
	public String getBugOpenClose()
	{
		return this.bugOpenClose;
	}

	/**
	 * Setter method : setOpenClose
	 * @param openClose the openClose to set
	 * 
	 * Date          : Dec 18, 2011 10:05:50 AM
	 */
	public void setBugOpenClose(String openClose)
	{
		this.bugOpenClose = openClose;
	}

	/**
	 * Getter Method	: getBugComments
	 * @return the bugComments
	 * 
	 * Date				: Aug 21, 2011
	 */
	public List<BugComments> getBugComments()
	{
		return this.bugComments;
	}
	/**
	 * Setter method : setBugComments
	 * @param bugComments the bugComments to set
	 * 
	 * Date          : Aug 21, 2011 12:52:12 PM
	 */
	public void setBugComments(List<BugComments> bugComments)
	{
		this.bugComments = bugComments;
	}
	
	
	
}
