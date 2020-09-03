package br.com.mind5.masterData.weekday.model;

import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.masterData.weekday.model.decisionTree.RootWeekdaySearch;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class WeekdayModelSelect extends ModelTemplate<WeekdayInfo> {

	public WeekdayModelSelect(WeekdayInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<WeekdayInfo> getDecisionTreeHook(DeciTreeOption<WeekdayInfo> option) {
		return new RootWeekdaySearch(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
