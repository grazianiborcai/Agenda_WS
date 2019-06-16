package br.com.gda.payment.ownerPartner.info;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class OwnparMergerOwner extends InfoMergerTemplate<OwnparInfo, OwnerInfo> {

	@Override protected InfoMergerVisitorV2<OwnparInfo, OwnerInfo> getVisitorHook() {
		return new OwnparVisiMergeOwner();
	}
	
	
	
	@Override protected InfoUniquifier<OwnparInfo> getUniquifierHook() {
		return new OwnparUniquifier();
	}
}
