package br.com.gda.business.address.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class AddressMergerToDelete extends InfoMergerTemplate<AddressInfo, AddressInfo> {

	@Override protected InfoMergerVisitorV2<AddressInfo, AddressInfo> getVisitorHook() {
		return new AddressVisiMergeToDelete();
	}
	
	
	
	@Override protected InfoUniquifier<AddressInfo> getUniquifierHook() {
		return new AddressUniquifier();
	}
}
