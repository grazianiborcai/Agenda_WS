package br.com.mind5.message.email.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmailMergerToSelect extends InfoMergerTemplate<EmailInfo, EmailInfo> {

	@Override protected InfoMergerVisitor<EmailInfo, EmailInfo> getVisitorHook() {
		return new EmailVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<EmailInfo> getUniquifierHook() {
		return new EmailUniquifier();
	}
}
