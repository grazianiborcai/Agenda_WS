package br.com.mind5.business.customerList.info;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

public final class CuslisMergerCusarch extends InfoMergerTemplate<CuslisInfo, CusarchInfo>{

	@Override protected InfoMergerVisitor<CuslisInfo, CusarchInfo> getVisitorHook() {
		return new CuslisVisiMergeCusarch();
	}
	
	
	
	@Override protected InfoUniquifier<CuslisInfo> getUniquifierHook() {
		return new CuslisUniquifier();
	}
}
