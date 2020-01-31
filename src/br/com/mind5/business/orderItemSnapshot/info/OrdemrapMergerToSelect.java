package br.com.mind5.business.orderItemSnapshot.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OrdemrapMergerToSelect extends InfoMergerTemplate_<OrdemrapInfo, OrdemrapInfo> {

	@Override protected InfoMergerVisitor_<OrdemrapInfo, OrdemrapInfo> getVisitorHook() {
		return new OrdemrapVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<OrdemrapInfo> getUniquifierHook() {
		return new OrdemrapUniquifier();
	}
}
