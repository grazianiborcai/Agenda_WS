package br.com.mind5.message.email.info;


import java.util.List;

import br.com.mind5.info.InfoCopier;
import br.com.mind5.message.emailWelcome.info.EmacomeInfo;
import br.com.mind5.security.userPassword.info.UpswdInfo;

public final class EmailCopier {	
	public static EmailInfo copyFromUpswd(UpswdInfo source) {
		InfoCopier<EmailInfo, UpswdInfo> copier = new EmailCopyUpswd();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<EmailInfo> copyFromUpswd(List<UpswdInfo> sources) {
		InfoCopier<EmailInfo, UpswdInfo> copier = new EmailCopyUpswd();
		return copier.makeCopy(sources);
	}
	
	
	
	public static EmailInfo copyFromEmacome(EmacomeInfo source) {
		InfoCopier<EmailInfo, EmacomeInfo> copier = new EmailCopyEmacome();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<EmailInfo> copyFromEmacome(List<EmacomeInfo> sources) {
		InfoCopier<EmailInfo, EmacomeInfo> copier = new EmailCopyEmacome();
		return copier.makeCopy(sources);
	}
}
