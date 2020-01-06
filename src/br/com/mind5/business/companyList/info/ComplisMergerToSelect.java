package br.com.mind5.business.companyList.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class ComplisMergerToSelect extends InfoMergerTemplate<ComplisInfo, ComplisInfo> {

	@Override protected InfoMergerVisitor<ComplisInfo, ComplisInfo> getVisitorHook() {
		return new ComplisVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<ComplisInfo> getUniquifierHook() {
		return new ComplisUniquifier();
	}	
}
