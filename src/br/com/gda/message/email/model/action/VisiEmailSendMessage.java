package br.com.gda.message.email.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.common.EmailSender;
import br.com.gda.message.email.info.EmailInfo;
import br.com.gda.model.action.ActionVisitorAction;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciResultHelper;
import br.com.gda.model.decisionTree.common.DeciResultError;

final class VisiEmailSendMessage implements ActionVisitorAction<EmailInfo> {
	private final boolean SUCCESS = true;
	private final boolean FAILED = false;
	
	
	@Override public DeciResult<EmailInfo> executeTransformation(List<EmailInfo> recordInfos) {
		boolean result = SUCCESS;
		
		for (EmailInfo eachRecord : recordInfos) {
			result = tryToSendMessage(eachRecord);
			
			if (result == FAILED)
				break;
		}
		
		return buildDeciResult(result);
	}
	
	
	
	private boolean tryToSendMessage(EmailInfo recordInfo) {
		try {
			EmailSender sender = buildEmailSender(recordInfo);
			sender.send();
			return SUCCESS;
			
		} catch (Exception e) {
			return FAILED;
		}
	}
	
	
	
	private EmailSender buildEmailSender(EmailInfo recordInfo) {		
		return new EmailSender().setHostname(recordInfo.smtpHostname)
								.setPort(String.valueOf(recordInfo.smtpPort))
								.setSender(recordInfo.senderAddr)
								.setSenderBody(recordInfo.bodyData.txtbody)
								.setSenderPassword(recordInfo.senderPass)
								.setSenderRecipient(recordInfo.recipientAddr)
								.setSenderSubject(recordInfo.bodyData.subject)
								.build();
	}
	
	
	
	private DeciResult<EmailInfo> buildDeciResult(boolean result) {		
		if (result == SUCCESS)
			return buildResultSuccess();
		
		return buildResultFailed();		
	}
	
	
	
	private DeciResult<EmailInfo> buildResultSuccess() {
		DeciResultHelper<EmailInfo> helper = new DeciResultHelper<>();
		
		List<EmailInfo> results = new ArrayList<>();
		results.add(new EmailInfo());
		
		helper.resultset = results;
		helper.isSuccess = true;
		helper.hasResultset = true;
		
		return helper;
	}
	
	
	
	private DeciResult<EmailInfo> buildResultFailed() {
		return new DeciResultError<EmailInfo>();
	}
}
