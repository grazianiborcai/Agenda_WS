package br.com.gda.business.customerList.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

public final class CuslisMergerToSelect extends InfoMergerTemplate<CuslisInfo, CuslisInfo>{

	@Override protected InfoMergerVisitor<CuslisInfo, CuslisInfo> getVisitorHook() {
		return new CuslisVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<CuslisInfo> getUniquifierHook() {
		return new CuslisUniquifier();
	}
}
