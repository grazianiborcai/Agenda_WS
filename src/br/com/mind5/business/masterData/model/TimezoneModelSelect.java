package br.com.mind5.business.masterData.model;

import br.com.mind5.business.masterData.info.TimezoneInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootTimezoneSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

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
