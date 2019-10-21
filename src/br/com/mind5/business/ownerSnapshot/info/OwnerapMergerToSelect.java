package br.com.mind5.business.ownerSnapshot.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OwnerapMergerToSelect extends InfoMergerTemplate<OwnerapInfo, OwnerapInfo> {

	@Override protected InfoMergerVisitor<OwnerapInfo, OwnerapInfo> getVisitorHook() {
		return new OwnerapVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<OwnerapInfo> getUniquifierHook() {
		return new OwnerapUniquifier();
	}
}
