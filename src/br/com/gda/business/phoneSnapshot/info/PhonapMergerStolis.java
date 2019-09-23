package br.com.gda.business.phoneSnapshot.info;

import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

public final class PhonapMergerStolis extends InfoMergerTemplate<PhonapInfo, StolisInfo>{

	@Override protected InfoMergerVisitor<PhonapInfo, StolisInfo> getVisitorHook() {
		return new PhonapVisiMergeStolis();
	}
	
	
	
	@Override protected InfoUniquifier<PhonapInfo> getUniquifierHook() {
		return new PhonapUniquifier();
	}
}
