package br.com.mind5.business.scheduleDay.model;

import br.com.mind5.business.scheduleDay.info.SchedayInfo;
import br.com.mind5.business.scheduleDay.model.decisionTree.RootSchedaySelectNext;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedayModelSelectNext extends ModelTemplate<SchedayInfo> {

	public SchedayModelSelectNext(SchedayInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<SchedayInfo> getDecisionTreeHook(DeciTreeOption<SchedayInfo> option) {
		return new RootSchedaySelectNext(option);
	}
}
