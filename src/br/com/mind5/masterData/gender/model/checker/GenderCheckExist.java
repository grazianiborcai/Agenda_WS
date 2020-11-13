package br.com.mind5.masterData.gender.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.gender.info.GenderInfo;
import br.com.mind5.masterData.gender.model.action.StdGenderDaoSelect;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class GenderCheckExist extends ModelCheckerTemplateActionV2<GenderInfo, GenderInfo> {
	
	public GenderCheckExist(ModelCheckerOption option) {
		super(option, GenderInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<GenderInfo> buildActionHook(DeciTreeOption<GenderInfo> option) {
		ActionStdV2<GenderInfo> select = new StdGenderDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.GENDER_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.GENDER_NOT_FOUND;
	}
}
