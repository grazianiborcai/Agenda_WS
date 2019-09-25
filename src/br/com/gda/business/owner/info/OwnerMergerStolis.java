package br.com.gda.business.owner.info;

import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class OwnerMergerStolis extends InfoMergerTemplate<OwnerInfo, StolisInfo> {

	@Override protected InfoMergerVisitor<OwnerInfo, StolisInfo> getVisitorHook() {
		return new OwnerVisiMergeStolis();
	}
	
	
	
	@Override protected InfoUniquifier<OwnerInfo> getUniquifierHook() {
		return new OwnerUniquifier();
	}
}
