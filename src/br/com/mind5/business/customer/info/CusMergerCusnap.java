package br.com.mind5.business.customer.info;

import br.com.mind5.business.customerSnapshot.info.CusnapInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

public final class CusMergerCusnap extends InfoMergerTemplate_<CusInfo, CusnapInfo>{

	@Override protected InfoMergerVisitor_<CusInfo, CusnapInfo> getVisitorHook() {
		return new CusVisiMergeCusnap();
	}
	
	
	
	@Override protected InfoUniquifier<CusInfo> getUniquifierHook() {
		return new CusUniquifier();
	}
}
