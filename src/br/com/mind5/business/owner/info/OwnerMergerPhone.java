package br.com.mind5.business.owner.info;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OwnerMergerPhone extends InfoMergerTemplate<OwnerInfo, PhoneInfo> {

	@Override protected InfoMergerVisitor<OwnerInfo, PhoneInfo> getVisitorHook() {
		return new OwnerVisiMergePhone();
	}
	
	
	
	@Override protected InfoUniquifier<OwnerInfo> getUniquifierHook() {
		return new OwnerUniquifier();
	}
}
