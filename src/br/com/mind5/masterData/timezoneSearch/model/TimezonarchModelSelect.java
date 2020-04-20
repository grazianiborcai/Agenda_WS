package br.com.mind5.masterData.timezoneSearch.model;

import br.com.mind5.masterData.timezoneSearch.info.TimezonarchInfo;
import br.com.mind5.masterData.timezoneSearch.model.decisionTree.RootTimezonarchSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class TimezonarchModelSelect extends ModelTemplate<TimezonarchInfo> {

	public TimezonarchModelSelect(TimezonarchInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<TimezonarchInfo> getDecisionTreeHook(DeciTreeOption<TimezonarchInfo> option) {
		return new RootTimezonarchSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}