package br.com.mind5.business.scheduleDay.model;

import br.com.mind5.business.scheduleDay.info.SchedayInfo;
import br.com.mind5.business.scheduleDay.model.decisionTree.RootSchedaySelectNow;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedayModelSelectNow extends ModelTemplate<SchedayInfo> {

	public SchedayModelSelectNow(SchedayInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<SchedayInfo> getDecisionTreeHook(DeciTreeOption<SchedayInfo> option) {
		return new RootSchedaySelectNow(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
