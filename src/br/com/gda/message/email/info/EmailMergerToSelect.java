package br.com.gda.message.email.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class EmailMergerToSelect extends InfoMergerTemplate<EmailInfo, EmailInfo> {

	@Override protected InfoMergerVisitor<EmailInfo, EmailInfo> getVisitorHook() {
		return new EmailVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<EmailInfo> getUniquifierHook() {
		return new EmailUniquifier();
	}
}
