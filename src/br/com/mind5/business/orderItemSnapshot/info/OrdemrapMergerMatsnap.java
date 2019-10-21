package br.com.mind5.business.orderItemSnapshot.info;

import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OrdemrapMergerMatsnap extends InfoMergerTemplate<OrdemrapInfo, MatsnapInfo> {

	@Override protected InfoMergerVisitor<OrdemrapInfo, MatsnapInfo> getVisitorHook() {
		return new OrdemrapVisiMergeMatsnap();
	}
	
	
	
	@Override protected InfoUniquifier<OrdemrapInfo> getUniquifierHook() {
		return new OrdemrapUniquifier();
	}
}
