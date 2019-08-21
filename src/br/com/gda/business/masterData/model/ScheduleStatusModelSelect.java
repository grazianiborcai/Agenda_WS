package br.com.gda.business.masterData.model;

import br.com.gda.business.masterData.info.ScheduleStatusInfo;
import br.com.gda.business.masterData.model.decisionTree.RootScheduleStatusSelect;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ScheduleStatusModelSelect extends ModelTemplate<ScheduleStatusInfo> {

	public ScheduleStatusModelSelect(ScheduleStatusInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<ScheduleStatusInfo> getDecisionTreeHook(DeciTreeOption<ScheduleStatusInfo> option) {
		return new RootScheduleStatusSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
