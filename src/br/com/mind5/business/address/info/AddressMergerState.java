package br.com.mind5.business.address.info;

import br.com.mind5.business.masterData.info.StateInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class AddressMergerState extends InfoMergerTemplate<AddressInfo, StateInfo> {

	@Override protected InfoMergerVisitor<AddressInfo, StateInfo> getVisitorHook() {
		return new AddressVisiMergeState();
	}
	
	
	
	@Override protected InfoUniquifier<AddressInfo> getUniquifierHook() {
		return new AddressUniquifier();
	}
}
