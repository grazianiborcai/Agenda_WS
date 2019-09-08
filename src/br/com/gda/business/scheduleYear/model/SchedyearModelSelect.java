package br.com.gda.business.scheduleYear.model;

import br.com.gda.business.scheduleYear.info.SchedyearInfo;
import br.com.gda.business.scheduleYear.model.decisionTree.RootSchedyearSelect;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class SchedyearModelSelect extends ModelTemplate<SchedyearInfo> {

	public SchedyearModelSelect(SchedyearInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<SchedyearInfo> getDecisionTreeHook(DeciTreeOption<SchedyearInfo> option) {
		return new RootSchedyearSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
