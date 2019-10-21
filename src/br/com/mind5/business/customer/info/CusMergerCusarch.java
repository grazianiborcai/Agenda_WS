package br.com.mind5.business.customer.info;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

public final class CusMergerCusarch extends InfoMergerTemplate<CusInfo, CusarchInfo>{

	@Override protected InfoMergerVisitor<CusInfo, CusarchInfo> getVisitorHook() {
		return new CusVisiMergeCusarch();
	}
	
	
	
	@Override protected InfoUniquifier<CusInfo> getUniquifierHook() {
		return new CusUniquifier();
	}
}
