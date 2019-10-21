package br.com.mind5.business.phone.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class PhoneMergerUsername extends InfoMergerTemplate<PhoneInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<PhoneInfo, UsernameInfo> getVisitorHook() {
		return new PhoneVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<PhoneInfo> getUniquifierHook() {
		return new PhoneUniquifier();
	}
}
