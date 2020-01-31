package br.com.mind5.business.customerSnapshot.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

public final class CusnapMergerToSelect extends InfoMergerTemplate_<CusnapInfo, CusnapInfo>{

	@Override protected InfoMergerVisitor_<CusnapInfo, CusnapInfo> getVisitorHook() {
		return new CusnapVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<CusnapInfo> getUniquifierHook() {
		return new CusnapUniquifier();
	}
}
