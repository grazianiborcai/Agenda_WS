package br.com.mind5.business.addressSnapshot.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class AddresnapMergerToSelect extends InfoMergerTemplate<AddresnapInfo, AddresnapInfo> {

	@Override protected InfoMergerVisitor<AddresnapInfo, AddresnapInfo> getVisitorHook() {
		return new AddresnapVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<AddresnapInfo> getUniquifierHook() {
		return new AddresnapUniquifier();
	}
}
