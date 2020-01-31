package br.com.mind5.business.phone.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.username.info.UsernameInfo;

final class PhoneMergerUsername extends InfoMergerTemplate_<PhoneInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor_<PhoneInfo, UsernameInfo> getVisitorHook() {
		return new PhoneVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<PhoneInfo> getUniquifierHook() {
		return new PhoneUniquifier();
	}
}
