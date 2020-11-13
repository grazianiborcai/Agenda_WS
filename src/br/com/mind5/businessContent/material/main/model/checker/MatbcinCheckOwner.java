package br.com.mind5.businessContent.material.main.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.businessContent.material.main.info.MatbcinInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class MatbcinCheckOwner extends ModelCheckerTemplateForward<MatbcinInfo, OwnerInfo> {
	
	public MatbcinCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(MatbcinInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
