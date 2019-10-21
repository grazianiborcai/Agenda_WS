package br.com.mind5.business.customer.info;

import br.com.mind5.business.customerSnapshot.info.CusnapInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

public final class CusMergerCusnap extends InfoMergerTemplate<CusInfo, CusnapInfo>{

	@Override protected InfoMergerVisitor<CusInfo, CusnapInfo> getVisitorHook() {
		return new CusVisiMergeCusnap();
	}
	
	
	
	@Override protected InfoUniquifier<CusInfo> getUniquifierHook() {
		return new CusUniquifier();
	}
}
