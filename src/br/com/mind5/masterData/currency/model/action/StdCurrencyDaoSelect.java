package br.com.mind5.masterData.currency.model.action;

import br.com.mind5.masterData.currency.info.CurrencyInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCurrencyDaoSelect extends ActionStdTemplateV2<CurrencyInfo> {

	public StdCurrencyDaoSelect(DeciTreeOption<CurrencyInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<CurrencyInfo> buildVisitorHook(DeciTreeOption<CurrencyInfo> option) {
		return new VisiCurrencyDaoSelect(option);
	}
}
