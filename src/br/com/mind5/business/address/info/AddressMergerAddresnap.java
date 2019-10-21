package br.com.mind5.business.address.info;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class AddressMergerAddresnap extends InfoMergerTemplate<AddressInfo, AddresnapInfo> {

	@Override protected InfoMergerVisitor<AddressInfo, AddresnapInfo> getVisitorHook() {
		return new AddressVisiMergeAddresnap();
	}
	
	
	
	@Override protected InfoUniquifier<AddressInfo> getUniquifierHook() {
		return new AddressUniquifier();
	}
}
