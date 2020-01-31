package br.com.mind5.business.address.info;

import br.com.mind5.business.masterData.info.StateInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class AddressMergerState extends InfoMergerTemplate_<AddressInfo, StateInfo> {

	@Override protected InfoMergerVisitor_<AddressInfo, StateInfo> getVisitorHook() {
		return new AddressVisiMergeState();
	}
	
	
	
	@Override protected InfoUniquifier<AddressInfo> getUniquifierHook() {
		return new AddressUniquifier();
	}
}
