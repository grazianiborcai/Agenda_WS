package br.com.gda.business.address.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class AddressMergerToUpdate extends InfoMergerTemplate<AddressInfo, AddressInfo> {

	@Override protected InfoMergerVisitor<AddressInfo, AddressInfo> getVisitorHook() {
		return new AddressVisiMergeToUpdate();
	}
	
	
	
	@Override protected InfoUniquifier<AddressInfo> getUniquifierHook() {
		return new AddressUniquifier();
	}
}
