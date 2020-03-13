package br.com.mind5.business.storeWorkTime.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.business.storeWorkTime.model.decisionTree.RootStowotmSearch;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StowotmModelSearch extends ModelTemplate<StowotmInfo> {

	public StowotmModelSearch(String incomingData, HttpServletRequest request) {
		super(incomingData, request, StowotmInfo.class);
	}
	
	
	
	@Override protected DeciTree<StowotmInfo> getDecisionTreeHook(DeciTreeOption<StowotmInfo> option) {
		return new RootStowotmSearch(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
