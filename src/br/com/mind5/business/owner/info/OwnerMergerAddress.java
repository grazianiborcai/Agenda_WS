package br.com.mind5.business.owner.info;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OwnerMergerAddress extends InfoMergerTemplate_<OwnerInfo, AddressInfo> {

	@Override protected InfoMergerVisitor_<OwnerInfo, AddressInfo> getVisitorHook() {
		return new OwnerVisiMergeAddress();
	}
	
	
	
	@Override protected InfoUniquifier<OwnerInfo> getUniquifierHook() {
		return new OwnerUniquifier();
	}
}
