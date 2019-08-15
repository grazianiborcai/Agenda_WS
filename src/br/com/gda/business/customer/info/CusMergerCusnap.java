package br.com.gda.business.customer.info;

import br.com.gda.business.customerSnapshot.info.CusnapInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

public final class CusMergerCusnap extends InfoMergerTemplate<CusInfo, CusnapInfo>{

	@Override protected InfoMergerVisitor<CusInfo, CusnapInfo> getVisitorHook() {
		return new CusVisiMergeCusnap();
	}
	
	
	
	@Override protected InfoUniquifier<CusInfo> getUniquifierHook() {
		return new CusUniquifier();
	}
}
