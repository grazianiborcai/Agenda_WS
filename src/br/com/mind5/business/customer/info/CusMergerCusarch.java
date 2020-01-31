package br.com.mind5.business.customer.info;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

public final class CusMergerCusarch extends InfoMergerTemplate_<CusInfo, CusarchInfo>{

	@Override protected InfoMergerVisitor_<CusInfo, CusarchInfo> getVisitorHook() {
		return new CusVisiMergeCusarch();
	}
	
	
	
	@Override protected InfoUniquifier<CusInfo> getUniquifierHook() {
		return new CusUniquifier();
	}
}
