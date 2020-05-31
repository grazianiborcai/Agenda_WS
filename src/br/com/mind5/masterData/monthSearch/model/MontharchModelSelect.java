package br.com.mind5.masterData.monthSearch.model;

import br.com.mind5.masterData.monthSearch.info.MontharchInfo;
import br.com.mind5.masterData.monthSearch.model.decisionTree.RootMontharchSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MontharchModelSelect extends ModelTemplate<MontharchInfo> {

	public MontharchModelSelect(MontharchInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<MontharchInfo> getDecisionTreeHook(DeciTreeOption<MontharchInfo> option) {
		return new RootMontharchSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
