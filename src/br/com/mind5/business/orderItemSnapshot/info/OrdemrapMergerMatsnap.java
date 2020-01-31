package br.com.mind5.business.orderItemSnapshot.info;

import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OrdemrapMergerMatsnap extends InfoMergerTemplate_<OrdemrapInfo, MatsnapInfo> {

	@Override protected InfoMergerVisitor_<OrdemrapInfo, MatsnapInfo> getVisitorHook() {
		return new OrdemrapVisiMergeMatsnap();
	}
	
	
	
	@Override protected InfoUniquifier<OrdemrapInfo> getUniquifierHook() {
		return new OrdemrapUniquifier();
	}
}
