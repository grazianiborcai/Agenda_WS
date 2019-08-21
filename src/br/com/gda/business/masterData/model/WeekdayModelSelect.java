package br.com.gda.business.masterData.model;

import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.business.masterData.model.decisionTree.RootWeekdaySelect;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

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
