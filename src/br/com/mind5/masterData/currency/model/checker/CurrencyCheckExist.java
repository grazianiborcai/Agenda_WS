package br.com.mind5.masterData.currency.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.currency.info.CurrencyInfo;
import br.com.mind5.masterData.currency.model.action.StdCurrencyDaoSelect;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CurrencyCheckExist extends ModelCheckerTemplateActionV2<CurrencyInfo, CurrencyInfo> {
	
	public CurrencyCheckExist(ModelCheckerOption option) {
		super(option, CurrencyInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<CurrencyInfo> buildActionHook(DeciTreeOption<CurrencyInfo> option) {
		ActionStdV2<CurrencyInfo> select = new StdCurrencyDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.CURRENCY_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CURRENCY_NOT_FOUND;
	}
}
