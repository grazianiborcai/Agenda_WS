package br.com.gda.business.address.info;

import br.com.gda.business.masterData.info.StateInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class AddressMergerState extends InfoMergerTemplate<AddressInfo, StateInfo> {

	@Override protected InfoMergerVisitor<AddressInfo, StateInfo> getVisitorHook() {
		return new AddressVisiMergeState();
	}
	
	
	
	@Override protected InfoUniquifier<AddressInfo> getUniquifierHook() {
		return new AddressUniquifier();
	}
}
