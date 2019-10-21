package br.com.mind5.business.masterData.model;

import br.com.mind5.business.masterData.info.WeekdayInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootWeekdaySelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class WeekdayModelSelect extends ModelTemplate<WeekdayInfo> {

	public WeekdayModelSelect(WeekdayInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<WeekdayInfo> getDecisionTreeHook(DeciTreeOption<WeekdayInfo> option) {
		return new RootWeekdaySelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
