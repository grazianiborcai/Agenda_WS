package br.com.mind5.message.email.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmailMergerToSelect extends InfoMergerTemplate_<EmailInfo, EmailInfo> {

	@Override protected InfoMergerVisitor_<EmailInfo, EmailInfo> getVisitorHook() {
		return new EmailVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<EmailInfo> getUniquifierHook() {
		return new EmailUniquifier();
	}
}
