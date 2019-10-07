package br.com.gda.business.storeWorkTime.model;

import javax.servlet.http.HttpServletRequest;
import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.business.storeWorkTime.model.decisionTree.RootStowotmUpdate;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StowotmModelUpdate extends ModelTemplate<StowotmInfo> {

	public StowotmModelUpdate(String incomingData, HttpServletRequest request) {
		super(incomingData, request, StowotmInfo.class);
	}
	
	
	
	@Override protected DeciTree<StowotmInfo> getDecisionTreeHook(DeciTreeOption<StowotmInfo> option) {
		return new RootStowotmUpdate(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
