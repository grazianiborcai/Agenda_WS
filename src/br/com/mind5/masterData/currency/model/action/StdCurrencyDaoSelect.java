package br.com.mind5.masterData.currency.model.action;

import br.com.mind5.masterData.currency.info.CurrencyInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCurrencyDaoSelect extends ActionStdTemplate<CurrencyInfo> {

	public StdCurrencyDaoSelect(DeciTreeOption<CurrencyInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CurrencyInfo> buildVisitorHook(DeciTreeOption<CurrencyInfo> option) {
		return new VisiCurrencyDaoSelect(option);
	}
}
