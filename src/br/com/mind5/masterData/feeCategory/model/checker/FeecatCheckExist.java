package br.com.mind5.masterData.feeCategory.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.feeCategory.info.FeecatInfo;
import br.com.mind5.masterData.feeCategory.model.action.FeecatVisiDaoSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FeecatCheckExist extends ModelCheckerTemplateAction<FeecatInfo, FeecatInfo> {
	
	public FeecatCheckExist(ModelCheckerOption option) {
		super(option, FeecatInfo.class);
	}
	
	
	
	@Override protected ActionStd<FeecatInfo> buildActionHook(DeciTreeOption<FeecatInfo> option) {
		ActionStd<FeecatInfo> select = new ActionStdCommom<FeecatInfo>(option, FeecatVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.FEE_CATEG_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.FEE_CATEG_NOT_FOUND;
	}
}
