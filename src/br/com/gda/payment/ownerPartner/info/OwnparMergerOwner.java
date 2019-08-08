package br.com.gda.payment.ownerPartner.info;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class OwnparMergerOwner extends InfoMergerTemplate<OwnparInfo, OwnerInfo> {

	@Override protected InfoMergerVisitor<OwnparInfo, OwnerInfo> getVisitorHook() {
		return new OwnparVisiMergeOwner();
	}
	
	
	
	@Override protected InfoUniquifier<OwnparInfo> getUniquifierHook() {
		return new OwnparUniquifier();
	}
}
