package br.com.mind5.masterData.timezoneSearch.model;

import br.com.mind5.masterData.timezoneSearch.info.TimezonarchInfo;
import br.com.mind5.masterData.timezoneSearch.model.decisionTree.TimezonarchRootSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class TimezonarchModelSelect extends ModelTemplate<TimezonarchInfo> {

	public TimezonarchModelSelect(TimezonarchInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<TimezonarchInfo> getDecisionTreeHook(DeciTreeOption<TimezonarchInfo> option) {
		return new TimezonarchRootSelect(option);
	}
}
