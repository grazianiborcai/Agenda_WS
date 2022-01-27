package br.com.mind5.business.scheduleLine.model.checker;

import br.com.mind5.business.petSearch.info.PetarchInfo;
import br.com.mind5.business.petSearch.model.checker.PetarchCheckExistPetUser;
import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class SchedineCheckPetarchUser extends ModelCheckerTemplateForward<SchedineInfo, PetarchInfo> {
	
	public SchedineCheckPetarchUser(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<PetarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new PetarchCheckExistPetUser(option);
	}
	
	
	
	@Override protected PetarchInfo toForwardClass(SchedineInfo baseRecord) {
		return PetarchInfo.copyFrom(baseRecord);
	}
}
