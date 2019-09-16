package br.com.gda.business.ownerSnapshot.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class OwnerapMergerToSelect extends InfoMergerTemplate<OwnerapInfo, OwnerapInfo> {

	@Override protected InfoMergerVisitor<OwnerapInfo, OwnerapInfo> getVisitorHook() {
		return new OwnerapVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<OwnerapInfo> getUniquifierHook() {
		return new OwnerapUniquifier();
	}
}
