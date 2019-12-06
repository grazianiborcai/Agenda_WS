package br.com.mind5.business.materialList.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialList.model.decisionTree.RootMatlisSearch;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatlisModelSearch extends ModelTemplate<MatlisInfo> {

	public MatlisModelSearch(String incomingData, HttpServletRequest request) {
		super(incomingData, request, MatlisInfo.class);
	}
	
	
	
	@Override protected DeciTree<MatlisInfo> getDecisionTreeHook(DeciTreeOption<MatlisInfo> option) {
		return new RootMatlisSearch(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
