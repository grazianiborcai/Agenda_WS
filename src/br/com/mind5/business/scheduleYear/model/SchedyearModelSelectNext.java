package br.com.mind5.business.scheduleYear.model;

import br.com.mind5.business.scheduleYear.info.SchedyearInfo;
import br.com.mind5.business.scheduleYear.model.decisionTree.SchedyearRootSelectNext;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedyearModelSelectNext extends ModelTemplate<SchedyearInfo> {

	public SchedyearModelSelectNext(SchedyearInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<SchedyearInfo> getDecisionTreeHook(DeciTreeOption<SchedyearInfo> option) {
		return new SchedyearRootSelectNext(option);
	}
}
