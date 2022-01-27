package br.com.mind5.business.scheduleLine.model.checker;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.business.pet.model.checker.PetCheckExist;
import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class SchedineCheckPet extends ModelCheckerTemplateForward<SchedineInfo, PetInfo> {
	
	public SchedineCheckPet(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<PetInfo> getCheckerHook(ModelCheckerOption option) {
		return new PetCheckExist(option);
	}
	
	
	
	@Override protected PetInfo toForwardClass(SchedineInfo baseRecord) {
		return PetInfo.copyFrom(baseRecord);
	}
}
