package br.com.mind5.business.masterData.model.checker;

import br.com.mind5.business.masterData.info.GenderInfo;
import br.com.mind5.business.masterData.model.action.StdGenderSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class GenderCheckExist extends ModelCheckerTemplateAction<GenderInfo, GenderInfo> {
	
	public GenderCheckExist(ModelCheckerOption option) {
		super(option, GenderInfo.class);
	}
	
	
	
	@Override protected ActionStd<GenderInfo> buildActionHook(DeciTreeOption<GenderInfo> option) {
		ActionStd<GenderInfo> select = new StdGenderSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.GENDER_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.GENDER_NOT_FOUND;
	}
}
