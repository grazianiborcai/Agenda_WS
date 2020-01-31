package br.com.mind5.business.addressSnapshot.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class AddresnapMergerToSelect extends InfoMergerTemplate_<AddresnapInfo, AddresnapInfo> {

	@Override protected InfoMergerVisitor_<AddresnapInfo, AddresnapInfo> getVisitorHook() {
		return new AddresnapVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<AddresnapInfo> getUniquifierHook() {
		return new AddresnapUniquifier();
	}
}
