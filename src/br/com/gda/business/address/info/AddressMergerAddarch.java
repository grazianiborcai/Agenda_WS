package br.com.gda.business.address.info;

import br.com.gda.business.addressSearch.info.AddarchInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class AddressMergerAddarch extends InfoMergerTemplate<AddressInfo, AddarchInfo> {

	@Override protected InfoMergerVisitor<AddressInfo, AddarchInfo> getVisitorHook() {
		return new AddressVisiMergeAddarch();
	}
	
	
	
	@Override protected InfoUniquifier<AddressInfo> getUniquifierHook() {
		return new AddressUniquifier();
	}
}
