package br.com.mind5.business.customer.model.checker;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class CusCheckOwner extends ModelCheckerTemplateForward<CusInfo, OwnerInfo> {
	
	public CusCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(CusInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
