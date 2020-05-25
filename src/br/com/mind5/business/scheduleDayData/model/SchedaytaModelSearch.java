package br.com.mind5.business.scheduleDayData.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.scheduleDayData.info.SchedaytaInfo;
import br.com.mind5.business.scheduleDayData.model.decisionTree.RootSchedaytaSearch;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedaytaModelSearch extends ModelTemplate<SchedaytaInfo> {

	public SchedaytaModelSearch(String incomingData, HttpServletRequest request) {
		super(incomingData, request, SchedaytaInfo.class);
	}
	
	
	
	@Override protected DeciTree<SchedaytaInfo> getDecisionTreeHook(DeciTreeOption<SchedaytaInfo> option) {
		return new RootSchedaytaSearch(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
