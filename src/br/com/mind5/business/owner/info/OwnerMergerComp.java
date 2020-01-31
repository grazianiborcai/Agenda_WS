package br.com.mind5.business.owner.info;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OwnerMergerComp extends InfoMergerTemplate_<OwnerInfo, CompInfo> {

	@Override protected InfoMergerVisitor_<OwnerInfo, CompInfo> getVisitorHook() {
		return new OwnerVisiMergeComp();
	}
	
	
	
	@Override protected InfoUniquifier<OwnerInfo> getUniquifierHook() {
		return new OwnerUniquifier();
	}
}
