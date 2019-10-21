package br.com.mind5.business.orderItemSnapshot.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OrdemrapMergerToSelect extends InfoMergerTemplate<OrdemrapInfo, OrdemrapInfo> {

	@Override protected InfoMergerVisitor<OrdemrapInfo, OrdemrapInfo> getVisitorHook() {
		return new OrdemrapVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<OrdemrapInfo> getUniquifierHook() {
		return new OrdemrapUniquifier();
	}
}
