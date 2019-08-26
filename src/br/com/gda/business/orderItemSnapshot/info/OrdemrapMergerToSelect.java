package br.com.gda.business.orderItemSnapshot.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class OrdemrapMergerToSelect extends InfoMergerTemplate<OrdemrapInfo, OrdemrapInfo> {

	@Override protected InfoMergerVisitor<OrdemrapInfo, OrdemrapInfo> getVisitorHook() {
		return new OrdemrapVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<OrdemrapInfo> getUniquifierHook() {
		return new OrdemrapUniquifier();
	}
}
