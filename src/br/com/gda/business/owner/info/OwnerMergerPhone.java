package br.com.gda.business.owner.info;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class OwnerMergerPhone extends InfoMergerTemplate<OwnerInfo, PhoneInfo> {

	@Override protected InfoMergerVisitorV2<OwnerInfo, PhoneInfo> getVisitorHook() {
		return new OwnerVisiMergePhone();
	}
	
	
	
	@Override protected InfoUniquifier<OwnerInfo> getUniquifierHook() {
		return new OwnerUniquifier();
	}
}
