package br.com.mind5.payment.ownerPartner.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.payment.ownerPartner.info.OwnparInfo;

public final class OwnparCheckOwner extends ModelCheckerTemplateForward<OwnparInfo, OwnerInfo> {
	
	public OwnparCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(OwnparInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
