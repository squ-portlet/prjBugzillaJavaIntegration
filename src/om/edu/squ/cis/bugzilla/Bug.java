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
 * File Name			:	Bug.java
 * Package Name			:	om.edu.squ.cis.bugzilla
 * Date of creation		:	Aug 14, 2011  10:27:54 AM
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
package om.edu.squ.cis.bugzilla;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import om.edu.squ.cis.bugzilla.bo.BugComments;
import om.edu.squ.cis.bugzilla.bo.BugData;
import om.edu.squ.cis.bugzilla.util.BugProperty;
import om.edu.squ.cis.bugzilla.util.BugzillaAbstractRPCCall;
import om.edu.squ.cis.bugzilla.util.BugzillaLoginCall;
import om.edu.squ.cis.bugzilla.util.Constants;


import org.apache.xmlrpc.XmlRpcException;

/**
 * @author Bhabesh
 *
 */
public class Bug extends BugzillaAbstractRPCCall
{
	private  	String 	summary;
	private		String	filterSummary;
	private		String	description;
	
	public Bug() 
	{
		super();
		BugzillaLoginCall.login();
	}	

	public Bug(String paramSummary, String paramDescription)
	{
		super();
		BugzillaLoginCall.login();
		this.summary		=	paramSummary;
		this.description	=	paramDescription;
	}
	
	public Bug(String paramSummary)
	{
		super();
		BugzillaLoginCall.login();	
		this.summary		=	paramSummary;		
	}
	
	
	public  void 	setSummary(String paramSummary)
	{
		this.summary		=	paramSummary;
	}

	public String	getSummary()
	{
		return this.summary;
	}
	
	public void	setFilterSummary(String paramFilterSummary)
	{
		this.filterSummary	=	paramFilterSummary;
	}
	
	public void	setDescription(String paramDescription)
	{
		this.description	=	paramDescription;
	}
	
	/**
	 * 
	 * method name  : create
	 * @return
	 * Bug
	 * return type  : String
	 * 
	 * purpose		:
	 *
	 * Date    		:	Aug 22, 2011 12:28:15 PM
	 */
	public String create()
	{
		Map 	result	=	null;
		String	bugId	=	null;
		setCommand("Bug.create");
		
		Map<String,String> mapBug	=	new HashMap<String, String>();
		mapBug.put(BugProperty.getProperty(Constants.RESOURCE_PROPERTY_BUGZILLA_PRODUCT), BugProperty.getProperty(Constants.RESOURCE_PROPERTY_BUGZILLA_PRODUCT_NAME));
		mapBug.put(BugProperty.getProperty(Constants.RESOURCE_PROPERTY_BUGZILLA_PRODUCT_COMPONENT),BugProperty.getProperty(Constants.RESOURCE_PROPERTY_BUGZILLA_PRODUCT_COMPONENT_NAME));
		mapBug.put(BugProperty.getProperty(Constants.RESOURCE_PROPERTY_BUGZILLA_BUG_SUMMARY), summary);
		mapBug.put(BugProperty.getProperty(Constants.RESOURCE_PROPERTY_BUGZILLA_PRODUCT_VERSION), BugProperty.getProperty(Constants.RESOURCE_PROPERTY_BUGZILLA_PRODUCT_VERSION_NUMBER));
		mapBug.put(BugProperty.getProperty(Constants.RESOURCE_PROPERTY_BUGZILLA_BUG_DESCRIPTION), description);
		mapBug.put(BugProperty.getProperty(Constants.RESOURCE_PROPERTY_BUGZILLA_BUG_OPERATING_SYSTEM), BugProperty.getProperty(Constants.RESOURCE_PROPERTY_BUGZILLA_BUG_OPERATING_SYSTEM_NAME));
		mapBug.put(BugProperty.getProperty(Constants.RESOURCE_PROPERTY_BUGZILLA_BUG_PLATFORM), BugProperty.getProperty(Constants.RESOURCE_PROPERTY_BUGZILLA_BUG_PLATFORM_NAME));
		setParameter(mapBug);
		
	
		try
		{
			result	=	execute();
			bugId	=	 result.get(BugProperty.getProperty(Constants.RESOURCE_PROPERTY_BUGZILLA_WS_BUG_FIELD_ID)).toString();
		}
		catch(XmlRpcException ex)
		{
			ex.printStackTrace();
		}
		return bugId;
	}

	/**
	 * 
	 * method name  : getComments
	 * @param bugId
	 * @return
	 * Bug
	 * return type  : List<BugComments>
	 * 
	 * purpose		:
	 *
	 * Date    		:	Aug 22, 2011 12:06:23 PM
	 */
	private List<BugComments> getComments(String bugId)
	{
		List<BugComments>	lstComments	=	new ArrayList<BugComments>();
		Map result	=	null;
		
		setCommand("Bug.comments");
		
		Map<String,String>	mapBug	=	new HashMap<String,String>();
		mapBug.put(BugProperty.getProperty(Constants.RESOURCE_PROPERTY_BUGZILLA_WS_BUG_FIELD_IDS),bugId);
		setParameter(mapBug);
		try
		{
			result = execute();
			Map mapBugs	=	(Map)result.get(BugProperty.getProperty(Constants.RESOURCE_PROPERTY_BUGZILLA_WS_BUG_BUGS));
			Map	mapBugId =	(Map)mapBugs.get(bugId);
			Object[] comments	=	(Object[]) mapBugId.get(BugProperty.getProperty(Constants.RESOURCE_PROPERTY_BUGZILLA_WS_BUG_FIELD_COMMENTS));
		
			for (int i=0; i<comments.length; i++)
			{
				Map comment	=	(Map)comments[i];
				BugComments	bugComments	=	new BugComments	(
																bugId, 
																comment.get(BugProperty.getProperty(Constants.RESOURCE_PROPERTY_BUGZILLA_WS_BUG_FIELD_COMMENTS_AUTHOR)).toString(),
																comment.get(BugProperty.getProperty(Constants.RESOURCE_PROPERTY_BUGZILLA_WS_BUG_FIELD_COMMENTS_TIME)).toString(), 
																comment.get(BugProperty.getProperty(Constants.RESOURCE_PROPERTY_BUGZILLA_WS_BUG_FIELD_COMMENTS_TEXT)).toString()
															);
				
				lstComments.add(bugComments);
				bugComments	=	null;
				
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		mapBug	=	null;
		return lstComments;
		
	}

	/**
	 * 
	 * method name  : addComment
	 * @param paramBugId
	 * @param paramDescription
	 * Bug
	 * return type  : void
	 * 
	 * purpose		: Add a comment to a specific bug to bugzilla
	 *
	 * Date    		:	Sep 6, 2011 12:57:05 PM
	 */
	public void addComment(String paramBugId, String paramDescription)
	{
		Map result	=	null;
		setCommand("Bug.add_comment");
		Map<String,String> mapBug	=	new HashMap<String, String>();
		mapBug.put(BugProperty.getProperty(Constants.RESOURCE_PROPERTY_BUGZILLA_WS_BUG_FIELD_ID), paramBugId);
		mapBug.put(BugProperty.getProperty(Constants.RESOURCE_PROPERTY_BUGZILLA_WS_BUG_FIELD_COMMENT),paramDescription);
		setParameter(mapBug);
		
		try
		{
			result	=	execute();
		}
		catch(XmlRpcException ex)
		{
			ex.printStackTrace();
		}
		
	}
	
	
	
	
	/**
	 * 
	 * method name  : searchBug
	 * @return
	 * Bug
	 * return type  : List<BugData>
	 * 
	 * purpose		:
	 *
	 * Date    		:	Aug 23, 2011 8:49:47 AM
	 */
	public List <BugData> searchBug()
	{
		return searchBug(summary);
	}
	

	public List<BugData> searchBugById(String paramBugId)
	{
		List<BugData>	lstBugData	=	null;
		Map 			result		=	null;
		
		setCommand("Bug.search");
		
		
		Map<String,String>	mapBug	=	new HashMap<String,String>();
		mapBug.put(BugProperty.getProperty(Constants.RESOURCE_PROPERTY_BUGZILLA_PRODUCT), BugProperty.getProperty(Constants.RESOURCE_PROPERTY_BUGZILLA_PRODUCT_NAME));
		mapBug.put(BugProperty.getProperty(Constants.RESOURCE_PROPERTY_BUGZILLA_PRODUCT_COMPONENT),BugProperty.getProperty(Constants.RESOURCE_PROPERTY_BUGZILLA_PRODUCT_COMPONENT_NAME));
		mapBug.put(BugProperty.getProperty(Constants.RESOURCE_PROPERTY_BUGZILLA_WS_BUG_FIELD_ID), paramBugId);
		setParameter(mapBug);
		
		try
		{
			result = execute();
			//convertSearchResult(result);
			lstBugData	=	convertSearchResult(result,true);
		}
		catch(XmlRpcException ex)
		{
			ex.printStackTrace();
		}
		

		return lstBugData;
		
	}
	
	/**
	 * 
	 * method name  : searchBug
	 * @param searchInSummary
	 * @return
	 * Bug
	 * return type  : List<BugData>
	 * 
	 * purpose		:
	 *
	 * Date    		:	Aug 22, 2011 12:06:13 PM
	 */
	public List<BugData> searchBug(String searchInSummary)
	{
		List<BugData>	lstBugData	=	null;
		Map 			result		=	null;
		
		setCommand("Bug.search");
		
		java.util.Date bugdate1=new java.util.Date();


		Map<String,String>	mapBug	=	new HashMap<String,String>();
		mapBug.put(BugProperty.getProperty(Constants.RESOURCE_PROPERTY_BUGZILLA_PRODUCT), BugProperty.getProperty(Constants.RESOURCE_PROPERTY_BUGZILLA_PRODUCT_NAME));
		mapBug.put(BugProperty.getProperty(Constants.RESOURCE_PROPERTY_BUGZILLA_PRODUCT_COMPONENT),BugProperty.getProperty(Constants.RESOURCE_PROPERTY_BUGZILLA_PRODUCT_COMPONENT_NAME));
		mapBug.put(BugProperty.getProperty(Constants.RESOURCE_PROPERTY_BUGZILLA_BUG_SUMMARY), searchInSummary);
		setParameter(mapBug);
		
		try
		{
			java.util.Date bugdate2=new java.util.Date();


			result = execute();

			java.util.Date bugdate3=new java.util.Date();

			
			//convertSearchResult(result);
			
			lstBugData	=	convertSearchResult(result,false);
			
			java.util.Date bugdate4=new java.util.Date();


			
		}
		catch(XmlRpcException ex)
		{
			ex.printStackTrace();
		}
		
		mapBug	=	null;
		result	=	null;
		
		return lstBugData;
	}

	/**
	 * 
	 * method name  : convertSearchResult
	 * @param rpcSearchResult
	 * @return
	 * Bug
	 * return type  : List<BugData>
	 * 
	 * purpose		:
	 *
	 * Date    		:	Aug 22, 2011 12:06:04 PM
	 */
	private List<BugData> convertSearchResult(Map<String,Object[]> rpcSearchResult , boolean isComments)
	{
		List<BugData>	lstBugData	=	new	ArrayList<BugData>();
		
		Object[] untypedBugs = rpcSearchResult.get(BugProperty.getProperty(Constants.RESOURCE_PROPERTY_BUGZILLA_WS_BUG_BUGS));



		
		for (Object untypedBug : untypedBugs)
		{

			
			Map<String, Object> typedBug 	= (Map<String, Object>) untypedBug;
			
			

			
			String				summaryBug	=	typedBug.get(BugProperty.getProperty(Constants.RESOURCE_PROPERTY_BUGZILLA_WS_BUG_FIELD_ID_SUMMARY)).toString();
			String				bugId		=	typedBug.get(BugProperty.getProperty(Constants.RESOURCE_PROPERTY_BUGZILLA_WS_BUG_FIELD_ID)).toString();
			String				status		=	typedBug.get(BugProperty.getProperty(Constants.RESOURCE_PROPERTY_BUGZILLA_WS_BUG_FIELD_STATUS)).toString();
			String				openClose	=	typedBug.get(BugProperty.getProperty(Constants.RESOURCE_PROPERTY_BUGZILLA_WS_BUG_FIELD_OPEN_CLOSE)).toString();
								if(openClose.trim().equals("true"))
								{
									openClose	=	BugProperty.getProperty(Constants.RESOURCE_PROPERTY_BUGZILLA_WS_BUG_FIELD_OPEN_CLOSE_OPEN);
								}
								else
								{
									openClose	=	BugProperty.getProperty(Constants.RESOURCE_PROPERTY_BUGZILLA_WS_BUG_FIELD_OPEN_CLOSE_CLOSE);
								}
									
			if(null!=filterSummary)
			{
				int 	filter_index_start	=	summaryBug.indexOf(filterSummary);
						summaryBug			=	summaryBug.substring(0, filter_index_start);
			}
			
			BugData				bugData		=	null;
			if(isComments)
			{
				bugData		=	new	BugData
				(
						bugId,
						summaryBug,
						getComments(bugId)
				);				

			}
			else
			{
				bugData		=	new	BugData
				(
						bugId,
						summaryBug,
						status,
						openClose
				);				
				
			}

			
								lstBugData.add(bugData);	
								bugData		=	null;	
								typedBug	=	null;					
		}
		
		return lstBugData;
	}
	
	
	public static void main(String args[])
	{
	/*	
		Bug	bug	=	new Bug();

		//List<BugData>	lstBugData	=	bug.searchBug("00portal user:bhabesh00");
		List<BugData>	lstBugData	=	bug.searchBugById("907");
		
		for (int i=0; i<lstBugData.size(); i++)
		{
			BugData	bugdata	=	lstBugData.get(i);
	
			System.out.println("bugid : "+bugdata.getBugId());
			System.out.println("bugSummary : "+bugdata.getBugSummary());
	
			for(int j=0;j<bugdata.getBugComments().size(); j++)
			{
				System.out.println("--Author ["+j+"] "+bugdata.getBugComments().get(j).getAuthor());
				System.out.println("--comment ["+j+"] "+bugdata.getBugComments().get(j).getComment());
			}
			System.out.println("-----------------------------------------------------------------");
			
			
		}
		*/ 	
/*
		Bug	bug	=	new Bug("test_4 00portal user:bhabesh00", "test_description_4");
			System.out.println("bug id : "+bug.create());
	*/
		Bug	bug	=	new Bug();
		//Bug	bug	=	new Bug();Bug bug = new Bug("test 40(Portlet : leaveBal)");
		//bug.addComment("921", "This comment is from command prompt. pls. ignore.");
		bug.searchBugById("1040");
		
	}
	
		
		
		
		
		
}
