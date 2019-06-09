package br.com.gda.message.email.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class EmailMergerToSelect extends InfoMergerTemplate<EmailInfo, EmailInfo> {

	@Override protected InfoMergerVisitorV2<EmailInfo, EmailInfo> getVisitorHook() {
		return new EmailVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<EmailInfo> getUniquifierHook() {
		return new EmailUniquifier();
	}
}
