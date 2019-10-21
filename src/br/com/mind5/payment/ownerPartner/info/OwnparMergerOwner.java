package br.com.mind5.payment.ownerPartner.info;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OwnparMergerOwner extends InfoMergerTemplate<OwnparInfo, OwnerInfo> {

	@Override protected InfoMergerVisitor<OwnparInfo, OwnerInfo> getVisitorHook() {
		return new OwnparVisiMergeOwner();
	}
	
	
	
	@Override protected InfoUniquifier<OwnparInfo> getUniquifierHook() {
		return new OwnparUniquifier();
	}
}
