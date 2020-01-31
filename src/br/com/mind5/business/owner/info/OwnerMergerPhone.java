package br.com.mind5.business.owner.info;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OwnerMergerPhone extends InfoMergerTemplate_<OwnerInfo, PhoneInfo> {

	@Override protected InfoMergerVisitor_<OwnerInfo, PhoneInfo> getVisitorHook() {
		return new OwnerVisiMergePhone();
	}
	
	
	
	@Override protected InfoUniquifier<OwnerInfo> getUniquifierHook() {
		return new OwnerUniquifier();
	}
}
