package br.com.mind5.business.orderItemSnapshot.info;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OrdemrapMergerStolis extends InfoMergerTemplate<OrdemrapInfo, StolisInfo> {

	@Override protected InfoMergerVisitor<OrdemrapInfo, StolisInfo> getVisitorHook() {
		return new OrdemrapVisiMergeStolis();
	}
	
	
	
	@Override protected InfoUniquifier<OrdemrapInfo> getUniquifierHook() {
		return new OrdemrapUniquifier();
	}
}
