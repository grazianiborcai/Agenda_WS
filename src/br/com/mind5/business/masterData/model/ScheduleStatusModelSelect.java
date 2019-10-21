package br.com.mind5.business.masterData.model;

import br.com.mind5.business.masterData.info.ScheduleStatusInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootScheduleStatusSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

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
