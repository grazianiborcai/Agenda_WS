package br.com.mind5.masterData.petType.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.petType.info.PetypeInfo;
import br.com.mind5.masterData.petType.model.action.PetypeVisiDaoSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PetypeCheckExist extends ModelCheckerTemplateAction<PetypeInfo, PetypeInfo> {
	
	public PetypeCheckExist(ModelCheckerOption option) {
		super(option, PetypeInfo.class);
	}
	
	
	
	@Override protected ActionStd<PetypeInfo> buildActionHook(DeciTreeOption<PetypeInfo> option) {
		ActionStd<PetypeInfo> select = new ActionStdCommom<PetypeInfo>(option, PetypeVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PET_TYPE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PET_TYPE_NOT_FOUND;
	}
}
