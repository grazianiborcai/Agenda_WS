package br.com.mind5.business.scheduleYear.model;

import br.com.mind5.business.scheduleYear.info.SchedyearInfo;
import br.com.mind5.business.scheduleYear.model.decisionTree.RootSchedyearSelectNow;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedyearModelSelectNow extends ModelTemplate<SchedyearInfo> {

	public SchedyearModelSelectNow(SchedyearInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<SchedyearInfo> getDecisionTreeHook(DeciTreeOption<SchedyearInfo> option) {
		return new RootSchedyearSelectNow(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
