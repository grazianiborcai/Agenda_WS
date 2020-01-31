package br.com.mind5.business.ownerSnapshot.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OwnerapMergerToSelect extends InfoMergerTemplate_<OwnerapInfo, OwnerapInfo> {

	@Override protected InfoMergerVisitor_<OwnerapInfo, OwnerapInfo> getVisitorHook() {
		return new OwnerapVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<OwnerapInfo> getUniquifierHook() {
		return new OwnerapUniquifier();
	}
}
