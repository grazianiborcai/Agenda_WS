package br.com.mind5.business.customerList.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

public final class CuslisMergerToSelect extends InfoMergerTemplate_<CuslisInfo, CuslisInfo>{

	@Override protected InfoMergerVisitor_<CuslisInfo, CuslisInfo> getVisitorHook() {
		return new CuslisVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<CuslisInfo> getUniquifierHook() {
		return new CuslisUniquifier();
	}
}
