package br.com.gda.business.customer.info;

import br.com.gda.business.customerSearch.info.CusarchInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

public final class CusMergerCusarch extends InfoMergerTemplate<CusInfo, CusarchInfo>{

	@Override protected InfoMergerVisitor<CusInfo, CusarchInfo, CusInfo> getVisitorHook() {
		return new CusVisiMergeCusarch();
	}
	
	
	
	@Override protected InfoUniquifier<CusInfo> getUniquifierHook() {
		return new CusUniquifier();
	}
}
