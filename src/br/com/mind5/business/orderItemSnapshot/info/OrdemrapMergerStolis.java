package br.com.mind5.business.orderItemSnapshot.info;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OrdemrapMergerStolis extends InfoMergerTemplate_<OrdemrapInfo, StolisInfo> {

	@Override protected InfoMergerVisitor_<OrdemrapInfo, StolisInfo> getVisitorHook() {
		return new OrdemrapVisiMergeStolis();
	}
	
	
	
	@Override protected InfoUniquifier<OrdemrapInfo> getUniquifierHook() {
		return new OrdemrapUniquifier();
	}
}
