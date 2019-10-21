package br.com.mind5.business.customerList.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

public final class CuslisMergerToSelect extends InfoMergerTemplate<CuslisInfo, CuslisInfo>{

	@Override protected InfoMergerVisitor<CuslisInfo, CuslisInfo> getVisitorHook() {
		return new CuslisVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<CuslisInfo> getUniquifierHook() {
		return new CuslisUniquifier();
	}
}
