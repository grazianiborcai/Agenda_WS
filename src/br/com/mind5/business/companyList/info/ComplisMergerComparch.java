package br.com.mind5.business.companyList.info;

import br.com.mind5.business.companySearch.info.ComparchInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class ComplisMergerComparch extends InfoMergerTemplate<ComplisInfo, ComparchInfo> {

	@Override protected InfoMergerVisitor<ComplisInfo, ComparchInfo> getVisitorHook() {
		return new ComplisVisiMergeComparch();
	}
	
	
	
	@Override protected InfoUniquifier<ComplisInfo> getUniquifierHook() {
		return new ComplisUniquifier();
	}
}
