package br.com.mind5.masterData.scheduleStatus.model;

import br.com.mind5.masterData.scheduleStatus.info.SchedatusInfo;
import br.com.mind5.masterData.scheduleStatus.model.decisionTree.RootSchedatusSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedatusModelSelect extends ModelTemplate<SchedatusInfo> {

	public SchedatusModelSelect(SchedatusInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<SchedatusInfo> getDecisionTreeHook(DeciTreeOption<SchedatusInfo> option) {
		return new RootSchedatusSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
