<%@ page contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1" %>
<%@ page import="com.businessobjects.samples.CRJavaHelper,
com.crystaldecisions.sdk.occa.report.application.OpenReportOptions,
com.crystaldecisions.sdk.occa.report.application.ReportClientDocument,
com.crystaldecisions.sdk.occa.report.lib.ReportSDKExceptionBase,
com.crystaldecisions.sdk.occa.report.document.ISummaryInfo,
com.crystaldecisions.sdk.occa.report.document.IReportDocument,
java.util.Calendar,
java.text.DateFormat,
java.text.SimpleDateFormat,
java.util.Date"%>
<%
	// This sample code calls methods from the CRJavaHelper class, which 
	// contains examples of how to use the BusinessObjects APIs. You are free to 
	// modify and distribute the source code contained in the CRJavaHelper class. 

	try {

		String reportName = "FirstReport.rpt";
		ReportClientDocument clientDoc = (ReportClientDocument) session.getAttribute(reportName);

		if (clientDoc == null) {
			System.out.println("clientDoc is definiely null");
			// Report can be opened from the relative location specified in the CRConfig.xml, or the report location
			// tag can be removed to open the reports as Java resources or using an absolute path
			// (absolute path not recommended for Web applications).

			clientDoc = new ReportClientDocument();
			clientDoc.setReportAppServer(ReportClientDocument.inprocConnectionString);
			
			// Open report
			System.out.println("BEFORE OPEN");			
			clientDoc.open(reportName, OpenReportOptions._openAsReadOnly);
			System.out.println("AFTER OPEN");			
			IReportDocument reportDocument = clientDoc.getReportDocument();			
		    System.out.println("IReportDocument : "+ reportDocument );
		    
		    reportDocument.getSummaryInfo().setTitle("TITTLE");
		    clientDoc.setSummaryInfo(reportDocument.getSummaryInfo());
			
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			
			// ****** BEGIN CONNECT PARAMETERS SNIPPET ****************			
			
			// ****** END CONNECT PARAMETERS SNIPPET ****************	
		

			// Store the report document in session
			session.setAttribute(reportName, clientDoc);

		}

			
		// ****** BEGIN EXPORT PDF SNIPPET ****************
		{
			CRJavaHelper.exportPDF(clientDoc, response, true);
		}
		// ****** END EXPORT PDF SNIPPET ****************
	
	


	} catch (ReportSDKExceptionBase e) {
	    out.println(e);
	}
	
%>