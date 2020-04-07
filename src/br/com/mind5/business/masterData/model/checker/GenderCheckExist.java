package br.com.mind5.business.masterData.model.checker;

import br.com.mind5.business.masterData.info.GenderInfo;
import br.com.mind5.business.masterData.model.action.StdGenderSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class GenderCheckExist extends ModelCheckerTemplateActionV2<GenderInfo, GenderInfo> {
	
	public GenderCheckExist(ModelCheckerOption option) {
		super(option, GenderInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<GenderInfo> buildActionHook(DeciTreeOption<GenderInfo> option) {
		ActionStdV1<GenderInfo> select = new StdGenderSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.GENDER_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.GENDER_NOT_FOUND;
	}
}
