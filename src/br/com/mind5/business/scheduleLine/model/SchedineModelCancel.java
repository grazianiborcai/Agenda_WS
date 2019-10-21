package br.com.mind5.business.scheduleLine.model;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.model.decisionTree.RootSchedineCancel;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedineModelCancel extends ModelTemplate<SchedineInfo> {

	public SchedineModelCancel(SchedineInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<SchedineInfo> getDecisionTreeHook(DeciTreeOption<SchedineInfo> option) {
		return new RootSchedineCancel(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
