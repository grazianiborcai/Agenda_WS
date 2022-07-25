package br.com.mind5.masterData.discountStrategy.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.discountStrategy.info.DisegyInfo;
import br.com.mind5.masterData.discountStrategy.model.action.DisegyVisiDaoSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class DisegyCheckExist extends ModelCheckerTemplateAction<DisegyInfo, DisegyInfo> {
	
	public DisegyCheckExist(ModelCheckerOption option) {
		super(option, DisegyInfo.class);
	}
	
	
	
	@Override protected ActionStd<DisegyInfo> buildActionHook(DeciTreeOption<DisegyInfo> option) {
		ActionStd<DisegyInfo> select = new ActionStdCommom<DisegyInfo>(option, DisegyVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.DISCOUNT_STRATEGY_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.DISCOUNT_STRATEGY_NOT_FOUND;
	}
}
