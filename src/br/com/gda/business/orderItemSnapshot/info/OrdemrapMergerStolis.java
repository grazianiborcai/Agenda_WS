package br.com.gda.business.orderItemSnapshot.info;

import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class OrdemrapMergerStolis extends InfoMergerTemplate<OrdemrapInfo, StolisInfo> {

	@Override protected InfoMergerVisitor<OrdemrapInfo, StolisInfo> getVisitorHook() {
		return new OrdemrapVisiMergeStolis();
	}
	
	
	
	@Override protected InfoUniquifier<OrdemrapInfo> getUniquifierHook() {
		return new OrdemrapUniquifier();
	}
}
