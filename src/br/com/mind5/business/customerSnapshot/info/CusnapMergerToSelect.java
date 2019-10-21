package br.com.mind5.business.customerSnapshot.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

public final class CusnapMergerToSelect extends InfoMergerTemplate<CusnapInfo, CusnapInfo>{

	@Override protected InfoMergerVisitor<CusnapInfo, CusnapInfo> getVisitorHook() {
		return new CusnapVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<CusnapInfo> getUniquifierHook() {
		return new CusnapUniquifier();
	}
}
