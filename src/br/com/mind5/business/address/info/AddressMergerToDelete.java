package br.com.mind5.business.address.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class AddressMergerToDelete extends InfoMergerTemplate<AddressInfo, AddressInfo> {

	@Override protected InfoMergerVisitor<AddressInfo, AddressInfo> getVisitorHook() {
		return new AddressVisiMergeToDelete();
	}
	
	
	
	@Override protected InfoUniquifier<AddressInfo> getUniquifierHook() {
		return new AddressUniquifier();
	}
}
