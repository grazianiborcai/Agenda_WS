package br.com.mind5.business.customerSearch.model.checker;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class CusarchCheckOwner extends ModelCheckerTemplateForward<CusarchInfo, OwnerInfo> {
	
	public CusarchCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(CusarchInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
