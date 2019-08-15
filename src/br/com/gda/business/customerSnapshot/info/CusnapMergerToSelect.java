package br.com.gda.business.customerSnapshot.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

public final class CusnapMergerToSelect extends InfoMergerTemplate<CusnapInfo, CusnapInfo>{

	@Override protected InfoMergerVisitor<CusnapInfo, CusnapInfo> getVisitorHook() {
		return new CusnapVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<CusnapInfo> getUniquifierHook() {
		return new CusnapUniquifier();
	}
}
