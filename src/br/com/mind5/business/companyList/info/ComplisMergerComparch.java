package br.com.mind5.business.companyList.info;

import br.com.mind5.business.companySearch.info.ComparchInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class ComplisMergerComparch extends InfoMergerTemplate_<ComplisInfo, ComparchInfo> {

	@Override protected InfoMergerVisitor_<ComplisInfo, ComparchInfo> getVisitorHook() {
		return new ComplisVisiMergeComparch();
	}
	
	
	
	@Override protected InfoUniquifier<ComplisInfo> getUniquifierHook() {
		return new ComplisUniquifier();
	}
}
