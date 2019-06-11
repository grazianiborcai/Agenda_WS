package br.com.gda.message.email.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.message.emailBody.info.EmabodyInfo;

final class EmailMergerEmabody extends InfoMergerTemplate<EmailInfo, EmabodyInfo> {

	@Override protected InfoMergerVisitorV2<EmailInfo,  EmabodyInfo> getVisitorHook() {
		return new EmailVisiMergeEmabody();
	}
	
	
	
	@Override protected InfoUniquifier<EmailInfo> getUniquifierHook() {
		return new EmailUniquifier();
	}
}
