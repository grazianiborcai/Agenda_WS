package br.com.mind5.masterData.feeCategory.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.feeCategory.info.FeecatInfo;
import br.com.mind5.masterData.feeCategory.model.action.StdFeecatDaoSelect;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FeecatCheckExist extends ModelCheckerTemplateActionV2<FeecatInfo, FeecatInfo> {
	
	public FeecatCheckExist(ModelCheckerOption option) {
		super(option, FeecatInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<FeecatInfo> buildActionHook(DeciTreeOption<FeecatInfo> option) {
		ActionStdV1<FeecatInfo> select = new StdFeecatDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.FEE_CATEG_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.FEE_CATEG_NOT_FOUND;
	}
}
