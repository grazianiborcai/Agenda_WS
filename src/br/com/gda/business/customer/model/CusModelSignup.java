package br.com.gda.business.customer.model;

import javax.servlet.http.HttpServletRequest;
import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.business.customer.model.decisionTree.RootCusSignup;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class CusModelSignup extends ModelTemplate<CusInfo> {

	public CusModelSignup(String incomingData, HttpServletRequest request) {
		super(incomingData, request, CusInfo.class);
	}
	
	
	
	@Override protected DeciTree<CusInfo> getDecisionTreeHook(DeciTreeOption<CusInfo> option) {
		return new RootCusSignup(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
