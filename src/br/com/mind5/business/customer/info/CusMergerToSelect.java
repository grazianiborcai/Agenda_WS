package br.com.mind5.business.customer.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

public final class CusMergerToSelect extends InfoMergerTemplate<CusInfo, CusInfo>{

	@Override protected InfoMergerVisitor<CusInfo, CusInfo> getVisitorHook() {
		return new CusVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<CusInfo> getUniquifierHook() {
		return new CusUniquifier();
	}
}
