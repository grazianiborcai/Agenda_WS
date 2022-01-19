package br.com.mind5.business.pet.model.checker;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.business.pet.model.action.StdPetDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PetCheckExist extends ModelCheckerTemplateAction<PetInfo, PetInfo> {	
	
	public PetCheckExist(ModelCheckerOption option) {
		super(option, PetInfo.class);
	}
	
	
	
	@Override protected ActionStd<PetInfo> buildActionHook(DeciTreeOption<PetInfo> option) {
		ActionStd<PetInfo> select = new StdPetDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PET_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PET_NOT_FOUND;
	}
}
