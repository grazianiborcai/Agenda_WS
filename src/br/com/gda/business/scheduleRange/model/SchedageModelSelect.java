package br.com.gda.business.scheduleRange.model;

import br.com.gda.business.scheduleRange.info.SchedageInfo;
import br.com.gda.business.scheduleRange.model.decisionTree.RootSchedageSelect;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class SchedageModelSelect extends ModelTemplate<SchedageInfo> {

	public SchedageModelSelect(SchedageInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<SchedageInfo> getDecisionTreeHook(DeciTreeOption<SchedageInfo> option) {
		return new RootSchedageSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
