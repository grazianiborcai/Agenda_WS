package br.com.mind5.business.companyList.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class ComplisMergerToSelect extends InfoMergerTemplate_<ComplisInfo, ComplisInfo> {

	@Override protected InfoMergerVisitor_<ComplisInfo, ComplisInfo> getVisitorHook() {
		return new ComplisVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<ComplisInfo> getUniquifierHook() {
		return new ComplisUniquifier();
	}	
}
