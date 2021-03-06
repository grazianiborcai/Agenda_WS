package br.com.mind5.businessContent.material.petShop.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.businessContent.material.petShop.info.MatbcetInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class MatbcetCheckOwner extends ModelCheckerTemplateForward<MatbcetInfo, OwnerInfo> {
	
	public MatbcetCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(MatbcetInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
