package br.com.mind5.payment.storePartnerSearch.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.payment.storePartnerSearch.info.StoparchInfo;

public final class StoparchCheckOwner extends ModelCheckerTemplateForward<StoparchInfo, OwnerInfo> {
	
	public StoparchCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(StoparchInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
