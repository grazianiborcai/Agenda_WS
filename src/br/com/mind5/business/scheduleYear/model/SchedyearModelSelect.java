package br.com.mind5.business.scheduleYear.model;

import br.com.mind5.business.scheduleYear.info.SchedyearInfo;
import br.com.mind5.business.scheduleYear.model.decisionTree.RootSchedyearSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

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
