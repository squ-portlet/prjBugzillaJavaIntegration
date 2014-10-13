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
 * File Name			:	BugComments.java
 * Package Name			:	om.edu.squ.cis.bugzilla.bo
 * Date of creation		:	Aug 20, 2011  12:46:23 PM
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

/**
 * @author Bhabesh
 *
 */
public class BugComments
{
	private String	bugId;
	private	String	author;
	private	String	strTime;
	private	String	comment;

	public BugComments(){}
	public BugComments(String paramBugId, String paramAuthor, String paramTime, String paramComment)
	{
		this.bugId	 =	paramBugId;
		this.author	 =	paramAuthor;
		this.strTime =	paramTime;
		this.comment =	paramComment;
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
	 * Date          : Aug 21, 2011 9:20:30 AM
	 */
	public void setBugId(String bugId)
	{
		this.bugId = bugId;
	}
	/**
	 * Getter Method	: getAuthor
	 * @return the author
	 * 
	 * Date				: Aug 21, 2011
	 */
	public String getAuthor()
	{
		return this.author;
	}
	/**
	 * Setter method : setAuthor
	 * @param author the author to set
	 * 
	 * Date          : Aug 21, 2011 9:00:42 AM
	 */
	public void setAuthor(String author)
	{
		this.author = author;
	}
	/**
	 * Getter Method	: getStrTime
	 * @return the strTime
	 * 
	 * Date				: Aug 21, 2011
	 */
	public String getStrTime()
	{
		return this.strTime;
	}
	/**
	 * Setter method : setStrTime
	 * @param strTime the strTime to set
	 * 
	 * Date          : Aug 21, 2011 9:00:42 AM
	 */
	public void setStrTime(String strTime)
	{
		this.strTime = strTime;
	}
	/**
	 * Getter Method	: getComment
	 * @return the comment
	 * 
	 * Date				: Aug 21, 2011
	 */
	public String getComment()
	{
		return this.comment;
	}
	/**
	 * Setter method : setComment
	 * @param comment the comment to set
	 * 
	 * Date          : Aug 21, 2011 9:00:42 AM
	 */
	public void setComment(String comment)
	{
		this.comment = comment;
	}
	
	
	
	
}
