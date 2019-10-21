package br.com.mind5.business.masterData.model;

import br.com.mind5.business.masterData.info.MonthInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootMonthSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

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
