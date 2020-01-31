package br.com.mind5.business.phoneSnapshot.info;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

public final class PhonapMergerStolis extends InfoMergerTemplate_<PhonapInfo, StolisInfo>{

	@Override protected InfoMergerVisitor_<PhonapInfo, StolisInfo> getVisitorHook() {
		return new PhonapVisiMergeStolis();
	}
	
	
	
	@Override protected InfoUniquifier<PhonapInfo> getUniquifierHook() {
		return new PhonapUniquifier();
	}
}
