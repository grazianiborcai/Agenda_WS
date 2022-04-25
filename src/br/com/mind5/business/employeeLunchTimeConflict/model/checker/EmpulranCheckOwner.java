package br.com.mind5.business.employeeLunchTimeConflict.model.checker;

import br.com.mind5.business.employeeLunchTimeConflict.info.EmpulranInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class EmpulranCheckOwner extends ModelCheckerTemplateForward<EmpulranInfo, OwnerInfo> {
	
	public EmpulranCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(EmpulranInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
