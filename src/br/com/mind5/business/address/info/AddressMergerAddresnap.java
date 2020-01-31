package br.com.mind5.business.address.info;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class AddressMergerAddresnap extends InfoMergerTemplate_<AddressInfo, AddresnapInfo> {

	@Override protected InfoMergerVisitor_<AddressInfo, AddresnapInfo> getVisitorHook() {
		return new AddressVisiMergeAddresnap();
	}
	
	
	
	@Override protected InfoUniquifier<AddressInfo> getUniquifierHook() {
		return new AddressUniquifier();
	}
}
