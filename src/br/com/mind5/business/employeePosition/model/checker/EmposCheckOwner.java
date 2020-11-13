package br.com.mind5.business.employeePosition.model.checker;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class EmposCheckOwner extends ModelCheckerTemplateForward<EmposInfo, OwnerInfo> {
	
	public EmposCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(EmposInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
