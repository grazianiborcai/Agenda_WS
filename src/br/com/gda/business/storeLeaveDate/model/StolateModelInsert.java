package br.com.gda.business.storeLeaveDate.model;

import javax.servlet.http.HttpServletRequest;
import br.com.gda.business.storeLeaveDate.info.StolateInfo;
import br.com.gda.business.storeLeaveDate.model.decisionTree.RootStolateInsert;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StolateModelInsert extends ModelTemplate<StolateInfo> {

	public StolateModelInsert(String incomingData, HttpServletRequest request) {
		super(incomingData, request, StolateInfo.class);
	}
	
	
	
	@Override protected DeciTree<StolateInfo> getDecisionTreeHook(DeciTreeOption<StolateInfo> option) {
		return new RootStolateInsert(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
