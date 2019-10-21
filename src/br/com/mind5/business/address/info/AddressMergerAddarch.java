package br.com.mind5.business.address.info;

import br.com.mind5.business.addressSearch.info.AddarchInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class AddressMergerAddarch extends InfoMergerTemplate<AddressInfo, AddarchInfo> {

	@Override protected InfoMergerVisitor<AddressInfo, AddarchInfo> getVisitorHook() {
		return new AddressVisiMergeAddarch();
	}
	
	
	
	@Override protected InfoUniquifier<AddressInfo> getUniquifierHook() {
		return new AddressUniquifier();
	}
}
