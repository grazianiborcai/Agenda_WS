package br.com.mind5.business.employeeLunchTime.model.checker;

import br.com.mind5.business.employeeLunchTime.info.EmplutmInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class EmplutmCheckOwner extends ModelCheckerTemplateForward<EmplutmInfo, OwnerInfo> {
	
	public EmplutmCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(EmplutmInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
