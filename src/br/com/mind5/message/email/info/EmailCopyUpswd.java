package br.com.mind5.message.email.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.message.emailBody.info.EmabodyInfo;
import br.com.mind5.security.userPassword.info.UpswdInfo;

final class EmailCopyUpswd extends InfoCopierTemplate<EmailInfo, UpswdInfo>{
	
	public EmailCopyUpswd() {
		super();
	} 
	
	
	
	@Override protected EmailInfo makeCopyHook(UpswdInfo source) {
		EmailInfo result = new EmailInfo();
		result.bodyData = new EmabodyInfo();
		
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		result.recipientAddr = source.persolisData.email;
		result.bodyData.param01 = source.persolisData.name;
		result.bodyData.param02 = source.password;
		result.bodyData.param03 = source.username;
		
		return result;
	}
}
