package br.com.mind5.business.ownerList.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OwnelisMergerToSelect extends InfoMergerTemplate<OwnelisInfo, OwnelisInfo> {

	@Override protected InfoMergerVisitor<OwnelisInfo, OwnelisInfo> getVisitorHook() {
		return new OwnelisVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<OwnelisInfo> getUniquifierHook() {
		return new OwnelisUniquifier();
	}
}
