package br.com.mind5.business.addressSnapshot.info;

import br.com.mind5.business.masterData.info.StateInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class AddresnapMergerState extends InfoMergerTemplate<AddresnapInfo, StateInfo> {

	@Override protected InfoMergerVisitor<AddresnapInfo, StateInfo> getVisitorHook() {
		return new AddresnapVisiMergeState();
	}
	
	
	
	@Override protected InfoUniquifier<AddresnapInfo> getUniquifierHook() {
		return new AddresnapUniquifier();
	}
}
