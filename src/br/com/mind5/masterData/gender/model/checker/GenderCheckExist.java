package br.com.mind5.masterData.gender.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.gender.info.GenderInfo;
import br.com.mind5.masterData.gender.model.action.StdGenderDaoSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class GenderCheckExist extends ModelCheckerTemplateAction<GenderInfo, GenderInfo> {
	
	public GenderCheckExist(ModelCheckerOption option) {
		super(option, GenderInfo.class);
	}
	
	
	
	@Override protected ActionStd<GenderInfo> buildActionHook(DeciTreeOption<GenderInfo> option) {
		ActionStd<GenderInfo> select = new StdGenderDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.GENDER_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.GENDER_NOT_FOUND;
	}
}
