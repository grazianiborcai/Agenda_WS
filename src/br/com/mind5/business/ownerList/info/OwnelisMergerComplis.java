package br.com.mind5.business.ownerList.info;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OwnelisMergerComplis extends InfoMergerTemplate<OwnelisInfo, ComplisInfo> {

	@Override protected InfoMergerVisitor<OwnelisInfo, ComplisInfo> getVisitorHook() {
		return new OwnelisVisiMergeComplis();
	}
	
	
	
	@Override protected InfoUniquifier<OwnelisInfo> getUniquifierHook() {
		return new OwnelisUniquifier();
	}
}
