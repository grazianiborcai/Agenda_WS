package br.com.gda.business.address.info;

import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class AddressMergerAddresnap extends InfoMergerTemplate<AddressInfo, AddresnapInfo> {

	@Override protected InfoMergerVisitorV2<AddressInfo, AddresnapInfo> getVisitorHook() {
		return new AddressVisiMergeAddresnap();
	}
	
	
	
	@Override protected InfoUniquifier<AddressInfo> getUniquifierHook() {
		return new AddressUniquifier();
	}
}
