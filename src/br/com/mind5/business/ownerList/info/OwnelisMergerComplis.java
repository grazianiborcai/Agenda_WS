package br.com.mind5.business.ownerList.info;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OwnelisMergerComplis extends InfoMergerTemplate_<OwnelisInfo, ComplisInfo> {

	@Override protected InfoMergerVisitor_<OwnelisInfo, ComplisInfo> getVisitorHook() {
		return new OwnelisVisiMergeComplis();
	}
	
	
	
	@Override protected InfoUniquifier<OwnelisInfo> getUniquifierHook() {
		return new OwnelisUniquifier();
	}
}
