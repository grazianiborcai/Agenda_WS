package br.com.gda.business.masterData.model;

import br.com.gda.business.masterData.info.MonthInfo;
import br.com.gda.business.masterData.model.decisionTree.RootMonthSelect;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class MonthModelSelect extends ModelTemplate<MonthInfo> {

	public MonthModelSelect(MonthInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<MonthInfo> getDecisionTreeHook(DeciTreeOption<MonthInfo> option) {
		return new RootMonthSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
