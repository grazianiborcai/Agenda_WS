package br.com.mind5.payment.ownerPartner.info;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OwnparMergerOwner extends InfoMergerTemplate_<OwnparInfo, OwnerInfo> {

	@Override protected InfoMergerVisitor_<OwnparInfo, OwnerInfo> getVisitorHook() {
		return new OwnparVisiMergeOwner();
	}
	
	
	
	@Override protected InfoUniquifier<OwnparInfo> getUniquifierHook() {
		return new OwnparUniquifier();
	}
}
