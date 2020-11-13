package br.com.mind5.business.orderList.model.checker;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class OrdistCheckOwner extends ModelCheckerTemplateForward<OrdistInfo, OwnerInfo> {
	
	public OrdistCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(OrdistInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
