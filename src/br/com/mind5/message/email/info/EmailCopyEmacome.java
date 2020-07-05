package br.com.mind5.message.email.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.message.emailWelcome.info.EmacomeInfo;

final class EmailCopyEmacome extends InfoCopierTemplate<EmailInfo, EmacomeInfo> {
	
	public EmailCopyEmacome() {
		super();
	} 
	
	
	
	@Override protected EmailInfo makeCopyHook(EmacomeInfo source) {
		EmailInfo result = new EmailInfo();
		
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		result.recipientAddr = source.persolisData.email;
		result.bodyData = source.bodyData;
		
		return result;
	}
}
