package br.com.mind5.message.email.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.message.emailBody.info.EmabodyInfo;

final class EmailMergerEmabody extends InfoMergerTemplate_<EmailInfo, EmabodyInfo> {

	@Override protected InfoMergerVisitor_<EmailInfo,  EmabodyInfo> getVisitorHook() {
		return new EmailVisiMergeEmabody();
	}
	
	
	
	@Override protected InfoUniquifier<EmailInfo> getUniquifierHook() {
		return new EmailUniquifier();
	}
}
