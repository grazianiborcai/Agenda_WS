package br.com.mind5.message.email.model.action;

import java.util.List;

import br.com.mind5.common.EmailSender;
import br.com.mind5.message.email.info.EmailInfo;
import br.com.mind5.model.action.ActionVisitorTemplateSimpleV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmailSendMessage extends ActionVisitorTemplateSimpleV2<EmailInfo> {
	private final boolean SUCCESS = true;
	private final boolean FAILED = false;
	
	
	public VisiEmailSendMessage(DeciTreeOption<EmailInfo> option) {
		super(option);
	}
	
	
	
	@Override public List<EmailInfo> executeTransformationHook(List<EmailInfo> recordInfos) {
		boolean result = SUCCESS;
		
		for (EmailInfo eachRecord : recordInfos) {
			result = tryToSendMessage(eachRecord);
			
			if (result == FAILED)
				return null;
		}
		
		return recordInfos;
	}
	
	
	
	private boolean tryToSendMessage(EmailInfo recordInfo) {
		try {
			EmailSender sender = buildEmailSender(recordInfo);
			sender.send();
			return SUCCESS;
			
		} catch (Exception e) {
			super.logException(e);
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
}
