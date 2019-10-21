package br.com.mind5.message.email.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.message.emailBody.info.EmabodyInfo;

final class EmailMergerEmabody extends InfoMergerTemplate<EmailInfo, EmabodyInfo> {

	@Override protected InfoMergerVisitor<EmailInfo,  EmabodyInfo> getVisitorHook() {
		return new EmailVisiMergeEmabody();
	}
	
	
	
	@Override protected InfoUniquifier<EmailInfo> getUniquifierHook() {
		return new EmailUniquifier();
	}
}
