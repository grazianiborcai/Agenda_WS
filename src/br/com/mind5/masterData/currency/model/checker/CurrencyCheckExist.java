package br.com.mind5.masterData.currency.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.currency.info.CurrencyInfo;
import br.com.mind5.masterData.currency.model.action.CurrencyVisiDaoSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CurrencyCheckExist extends ModelCheckerTemplateAction<CurrencyInfo, CurrencyInfo> {
	
	public CurrencyCheckExist(ModelCheckerOption option) {
		super(option, CurrencyInfo.class);
	}
	
	
	
	@Override protected ActionStd<CurrencyInfo> buildActionHook(DeciTreeOption<CurrencyInfo> option) {
		ActionStd<CurrencyInfo> select = new ActionStdCommom<CurrencyInfo>(option, CurrencyVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.CURRENCY_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CURRENCY_NOT_FOUND;
	}
}
