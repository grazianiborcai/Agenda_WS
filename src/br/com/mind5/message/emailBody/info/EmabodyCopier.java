package br.com.mind5.message.emailBody.info;


import java.util.List;

import br.com.mind5.info.InfoCopier;
import br.com.mind5.message.email.info.EmailInfo;

public final class EmabodyCopier {	
	public static EmabodyInfo copyFromEmail(EmailInfo source) {
		InfoCopier<EmabodyInfo, EmailInfo> copier = new EmabodyCopyEmail();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<EmabodyInfo> copyFromEmail(List<EmailInfo> sources) {
		InfoCopier<EmabodyInfo, EmailInfo> copier = new EmabodyCopyEmail();
		return copier.makeCopy(sources);
	}
}
