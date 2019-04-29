package br.com.gda.business.customer.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

public final class CusMergerToUpdateUser extends InfoMergerTemplate<CusInfo, CusInfo>{

	@Override protected InfoMergerVisitorV2<CusInfo, CusInfo> getVisitorHook() {
		return new CusVisiMergeToUpdateUser();
	}
	
	
	
	@Override protected InfoUniquifier<CusInfo> getUniquifierHook() {
		return new CusUniquifier();
	}
}
