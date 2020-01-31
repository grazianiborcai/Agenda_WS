package br.com.mind5.business.customer.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

public final class CusMergerToDelete extends InfoMergerTemplate_<CusInfo, CusInfo>{

	@Override protected InfoMergerVisitor_<CusInfo, CusInfo> getVisitorHook() {
		return new CusVisiMergeToDelete();
	}
	
	
	
	@Override protected InfoUniquifier<CusInfo> getUniquifierHook() {
		return new CusUniquifier();
	}
}
