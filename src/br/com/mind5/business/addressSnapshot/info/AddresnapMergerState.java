package br.com.mind5.business.addressSnapshot.info;

import br.com.mind5.business.masterData.info.StateInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class AddresnapMergerState extends InfoMergerTemplate_<AddresnapInfo, StateInfo> {

	@Override protected InfoMergerVisitor_<AddresnapInfo, StateInfo> getVisitorHook() {
		return new AddresnapVisiMergeState();
	}
	
	
	
	@Override protected InfoUniquifier<AddresnapInfo> getUniquifierHook() {
		return new AddresnapUniquifier();
	}
}
