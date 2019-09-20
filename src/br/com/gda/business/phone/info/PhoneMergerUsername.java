package br.com.gda.business.phone.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.username.info.UsernameInfo;

final class PhoneMergerUsername extends InfoMergerTemplate<PhoneInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<PhoneInfo, UsernameInfo> getVisitorHook() {
		return new PhoneVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<PhoneInfo> getUniquifierHook() {
		return new PhoneUniquifier();
	}
}
