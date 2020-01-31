package br.com.mind5.business.customerList.info;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

public final class CuslisMergerCusarch extends InfoMergerTemplate_<CuslisInfo, CusarchInfo>{

	@Override protected InfoMergerVisitor_<CuslisInfo, CusarchInfo> getVisitorHook() {
		return new CuslisVisiMergeCusarch();
	}
	
	
	
	@Override protected InfoUniquifier<CuslisInfo> getUniquifierHook() {
		return new CuslisUniquifier();
	}
}
