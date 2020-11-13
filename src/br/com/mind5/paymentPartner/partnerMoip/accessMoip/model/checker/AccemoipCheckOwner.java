package br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.info.AccemoipInfo;

public final class AccemoipCheckOwner extends ModelCheckerTemplateForward<AccemoipInfo, OwnerInfo> {
	
	public AccemoipCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(AccemoipInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
