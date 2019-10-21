package br.com.mind5.business.masterData.model;

import br.com.mind5.business.masterData.info.CurrencyInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootCurrencySelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CurrencyModelSelect extends ModelTemplate<CurrencyInfo> {

	public CurrencyModelSelect(CurrencyInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<CurrencyInfo> getDecisionTreeHook(DeciTreeOption<CurrencyInfo> option) {
		return new RootCurrencySelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
