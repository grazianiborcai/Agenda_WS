package br.com.mind5.business.addressSearch.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class AddarchMergerToSelect extends InfoMergerTemplate<AddarchInfo, AddarchInfo> {

	@Override protected InfoMergerVisitor<AddarchInfo, AddarchInfo> getVisitorHook() {
		return new AddarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<AddarchInfo> getUniquifierHook() {
		return new AddarchUniquifier();
	}
}
