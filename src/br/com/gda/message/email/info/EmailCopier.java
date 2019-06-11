package br.com.gda.message.email.info;


import java.util.List;

import br.com.gda.info.InfoCopier;
import br.com.gda.security.userPassword.info.UpswdInfo;

public final class EmailCopier {	
	public static EmailInfo copyFromUpswd(UpswdInfo source) {
		InfoCopier<EmailInfo, UpswdInfo> copier = new EmailCopyUpswd();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<EmailInfo> copyFromUpswd(List<UpswdInfo> sources) {
		InfoCopier<EmailInfo, UpswdInfo> copier = new EmailCopyUpswd();
		return copier.makeCopy(sources);
	}
}
