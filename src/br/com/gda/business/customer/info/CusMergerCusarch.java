package br.com.gda.business.customer.info;

import br.com.gda.business.customerSearch.info.CusarchInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

public final class CusMergerCusarch extends InfoMergerTemplate<CusInfo, CusarchInfo>{

	@Override protected InfoMergerVisitorV2<CusInfo, CusarchInfo> getVisitorHook() {
		return new CusVisiMergeCusarch();
	}
	
	
	
	@Override protected InfoUniquifier<CusInfo> getUniquifierHook() {
		return new CusUniquifier();
	}
}
