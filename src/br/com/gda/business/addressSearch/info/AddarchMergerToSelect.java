package br.com.gda.business.addressSearch.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class AddarchMergerToSelect extends InfoMergerTemplate<AddarchInfo, AddarchInfo> {

	@Override protected InfoMergerVisitor<AddarchInfo, AddarchInfo> getVisitorHook() {
		return new AddarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<AddarchInfo> getUniquifierHook() {
		return new AddarchUniquifier();
	}
}
