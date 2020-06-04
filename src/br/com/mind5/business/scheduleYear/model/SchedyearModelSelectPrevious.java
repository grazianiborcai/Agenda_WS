package br.com.mind5.business.scheduleYear.model;

import br.com.mind5.business.scheduleYear.info.SchedyearInfo;
import br.com.mind5.business.scheduleYear.model.decisionTree.RootSchedyearSelectPrevious;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedyearModelSelectPrevious extends ModelTemplate<SchedyearInfo> {

	public SchedyearModelSelectPrevious(SchedyearInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<SchedyearInfo> getDecisionTreeHook(DeciTreeOption<SchedyearInfo> option) {
		return new RootSchedyearSelectPrevious(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
