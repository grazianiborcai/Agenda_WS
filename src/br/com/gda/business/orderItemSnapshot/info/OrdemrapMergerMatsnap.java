package br.com.gda.business.orderItemSnapshot.info;

import br.com.gda.business.materialSnapshot.info.MatsnapInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class OrdemrapMergerMatsnap extends InfoMergerTemplate<OrdemrapInfo, MatsnapInfo> {

	@Override protected InfoMergerVisitor<OrdemrapInfo, MatsnapInfo> getVisitorHook() {
		return new OrdemrapVisiMergeMatsnap();
	}
	
	
	
	@Override protected InfoUniquifier<OrdemrapInfo> getUniquifierHook() {
		return new OrdemrapUniquifier();
	}
}
