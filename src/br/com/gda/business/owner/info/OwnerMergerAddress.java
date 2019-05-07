package br.com.gda.business.owner.info;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class OwnerMergerAddress extends InfoMergerTemplate<OwnerInfo, AddressInfo> {

	@Override protected InfoMergerVisitorV2<OwnerInfo, AddressInfo> getVisitorHook() {
		return new OwnerVisiMergeAddress();
	}
	
	
	
	@Override protected InfoUniquifier<OwnerInfo> getUniquifierHook() {
		return new OwnerUniquifier();
	}
}
