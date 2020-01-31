package br.com.mind5.business.addressSearch.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class AddarchMergerToSelect extends InfoMergerTemplate_<AddarchInfo, AddarchInfo> {

	@Override protected InfoMergerVisitor_<AddarchInfo, AddarchInfo> getVisitorHook() {
		return new AddarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<AddarchInfo> getUniquifierHook() {
		return new AddarchUniquifier();
	}
}
