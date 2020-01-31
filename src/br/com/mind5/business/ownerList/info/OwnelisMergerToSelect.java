package br.com.mind5.business.ownerList.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OwnelisMergerToSelect extends InfoMergerTemplate_<OwnelisInfo, OwnelisInfo> {

	@Override protected InfoMergerVisitor_<OwnelisInfo, OwnelisInfo> getVisitorHook() {
		return new OwnelisVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<OwnelisInfo> getUniquifierHook() {
		return new OwnelisUniquifier();
	}
}
