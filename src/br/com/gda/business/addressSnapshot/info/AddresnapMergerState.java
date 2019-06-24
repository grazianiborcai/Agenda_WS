package br.com.gda.business.addressSnapshot.info;

import br.com.gda.business.masterData.info.StateInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class AddresnapMergerState extends InfoMergerTemplate<AddresnapInfo, StateInfo> {

	@Override protected InfoMergerVisitorV2<AddresnapInfo, StateInfo> getVisitorHook() {
		return new AddresnapVisiMergeState();
	}
	
	
	
	@Override protected InfoUniquifier<AddresnapInfo> getUniquifierHook() {
		return new AddresnapUniquifier();
	}
}
