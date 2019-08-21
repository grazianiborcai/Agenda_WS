package br.com.gda.business.masterData.model;

import br.com.gda.business.masterData.info.TimezoneInfo;
import br.com.gda.business.masterData.model.decisionTree.RootTimezoneSelect;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class TimezoneModelSelect extends ModelTemplate<TimezoneInfo> {

	public TimezoneModelSelect(TimezoneInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<TimezoneInfo> getDecisionTreeHook(DeciTreeOption<TimezoneInfo> option) {
		return new RootTimezoneSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
