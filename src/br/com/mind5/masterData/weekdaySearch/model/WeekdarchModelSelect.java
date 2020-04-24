package br.com.mind5.masterData.weekdaySearch.model;

import br.com.mind5.masterData.weekdaySearch.info.WeekdarchInfo;
import br.com.mind5.masterData.weekdaySearch.model.decisionTree.RootWeekdarchSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class WeekdarchModelSelect extends ModelTemplate<WeekdarchInfo> {

	public WeekdarchModelSelect(WeekdarchInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<WeekdarchInfo> getDecisionTreeHook(DeciTreeOption<WeekdarchInfo> option) {
		return new RootWeekdarchSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
