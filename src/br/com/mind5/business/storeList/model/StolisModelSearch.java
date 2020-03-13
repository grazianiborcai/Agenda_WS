package br.com.mind5.business.storeList.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.business.storeList.model.decisionTree.RootStolisSearch;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StolisModelSearch extends ModelTemplate<StolisInfo> {

	public StolisModelSearch(String incomingData, HttpServletRequest request) {
		super(incomingData, request, StolisInfo.class);
	}
	
	
	
	@Override protected DeciTree<StolisInfo> getDecisionTreeHook(DeciTreeOption<StolisInfo> option) {
		return new RootStolisSearch(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
