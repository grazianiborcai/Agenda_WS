package br.com.mind5.business.ownerList.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.business.ownerList.model.decisionTree.RootOwnelisSearch;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OwnelisModelSearch extends ModelTemplate<OwnelisInfo> {

	public OwnelisModelSearch(String incomingData, HttpServletRequest request) {
		super(incomingData, request, OwnelisInfo.class);
	}
	
	
	
	@Override protected DeciTree<OwnelisInfo> getDecisionTreeHook(DeciTreeOption<OwnelisInfo> option) {
		return new RootOwnelisSearch(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
