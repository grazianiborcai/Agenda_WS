package br.com.mind5.business.scheduleLine.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.model.decisionTree.RootSchedineSearch;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedineModelSearch extends ModelTemplate<SchedineInfo> {

	public SchedineModelSearch(String incomingData, HttpServletRequest request) {
		super(incomingData, request, SchedineInfo.class);
	}
	
	
	
	@Override protected DeciTree<SchedineInfo> getDecisionTreeHook(DeciTreeOption<SchedineInfo> option) {
		return new RootSchedineSearch(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
