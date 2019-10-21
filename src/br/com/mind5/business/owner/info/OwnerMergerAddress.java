package br.com.mind5.business.owner.info;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OwnerMergerAddress extends InfoMergerTemplate<OwnerInfo, AddressInfo> {

	@Override protected InfoMergerVisitor<OwnerInfo, AddressInfo> getVisitorHook() {
		return new OwnerVisiMergeAddress();
	}
	
	
	
	@Override protected InfoUniquifier<OwnerInfo> getUniquifierHook() {
		return new OwnerUniquifier();
	}
}
