package br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.info.TokemoipInfo;

public final class TokemoipCheckOwner extends ModelCheckerTemplateForward<TokemoipInfo, OwnerInfo> {
	
	public TokemoipCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(TokemoipInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
