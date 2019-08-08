package br.com.gda.business.customer.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

public final class CusMergerToSelect extends InfoMergerTemplate<CusInfo, CusInfo>{

	@Override protected InfoMergerVisitor<CusInfo, CusInfo> getVisitorHook() {
		return new CusVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<CusInfo> getUniquifierHook() {
		return new CusUniquifier();
	}
}
