package br.com.mind5.business.address.info;

import br.com.mind5.business.addressSearch.info.AddarchInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class AddressMergerAddarch extends InfoMergerTemplate_<AddressInfo, AddarchInfo> {

	@Override protected InfoMergerVisitor_<AddressInfo, AddarchInfo> getVisitorHook() {
		return new AddressVisiMergeAddarch();
	}
	
	
	
	@Override protected InfoUniquifier<AddressInfo> getUniquifierHook() {
		return new AddressUniquifier();
	}
}
