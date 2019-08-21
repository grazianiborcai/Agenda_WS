package br.com.gda.business.masterData.model;

import br.com.gda.business.masterData.info.CurrencyInfo;
import br.com.gda.business.masterData.model.decisionTree.RootCurrencySelect;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

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
