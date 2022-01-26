package br.com.mind5.business.petDefault.model.checker;

import br.com.mind5.business.petDefault.info.PetaultInfo;
import br.com.mind5.business.petDefault.model.decisionTree.RootPetaultSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PetaultCheckExist extends ModelCheckerTemplateAction<PetaultInfo, PetaultInfo> {
	
	public PetaultCheckExist(ModelCheckerOption option) {
		super(option, PetaultInfo.class);
	}
	
	
	
	@Override protected ActionStd<PetaultInfo> buildActionHook(DeciTreeOption<PetaultInfo> option) {
		ActionStd<PetaultInfo> select = new RootPetaultSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PET_DEFAULT_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PET_DEFAULT_NOT_FOUND;
	}
}
