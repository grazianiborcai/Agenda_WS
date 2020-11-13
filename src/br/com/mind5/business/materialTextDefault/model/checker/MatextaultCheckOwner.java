package br.com.mind5.business.materialTextDefault.model.checker;

import br.com.mind5.business.materialTextDefault.info.MatextaultInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class MatextaultCheckOwner extends ModelCheckerTemplateForward<MatextaultInfo, OwnerInfo> {
	
	public MatextaultCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(MatextaultInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
