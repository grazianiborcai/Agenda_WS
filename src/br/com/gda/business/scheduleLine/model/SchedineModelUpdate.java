package br.com.gda.business.scheduleLine.model;

import javax.servlet.http.HttpServletRequest;

import br.com.gda.business.scheduleLine.info.SchedineInfo;
import br.com.gda.business.scheduleLine.model.decisionTree.RootSchedineUpdate;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class SchedineModelUpdate extends ModelTemplate<SchedineInfo> {

	public SchedineModelUpdate(String incomingData, HttpServletRequest request) {
		super(incomingData, request, SchedineInfo.class);
	}
	
	
	
	@Override protected DeciTree<SchedineInfo> getDecisionTreeHook(DeciTreeOption<SchedineInfo> option) {
		return new RootSchedineUpdate(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
