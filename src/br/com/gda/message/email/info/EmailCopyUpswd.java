package br.com.gda.message.email.info;

import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.message.emailBody.info.EmabodyInfo;
import br.com.gda.security.userPassword.info.UpswdInfo;

final class EmailCopyUpswd extends InfoCopierTemplate<EmailInfo, UpswdInfo>{
	
	public EmailCopyUpswd() {
		super();
	} 
	
	
	
	@Override protected EmailInfo makeCopyHook(UpswdInfo source) {
		EmailInfo result = new EmailInfo();
		result.bodyData = new EmabodyInfo();
		
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		result.recipientAddr = source.personData.email;
		result.bodyData.param01 = source.personData.name;
		result.bodyData.param02 = source.password;
		
		return result;
	}
}
