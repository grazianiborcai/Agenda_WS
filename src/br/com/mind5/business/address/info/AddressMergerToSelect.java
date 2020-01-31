package br.com.mind5.business.address.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class AddressMergerToSelect extends InfoMergerTemplate_<AddressInfo, AddressInfo> {

	@Override protected InfoMergerVisitor_<AddressInfo, AddressInfo> getVisitorHook() {
		return new AddressVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<AddressInfo> getUniquifierHook() {
		return new AddressUniquifier();
	}
}
