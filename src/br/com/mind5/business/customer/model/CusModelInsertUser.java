package br.com.mind5.business.customer.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.decisionTree.RootCusInsertUser;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CusModelInsertUser extends ModelTemplate<CusInfo> {

	public CusModelInsertUser(String incomingData, HttpServletRequest request) {
		super(incomingData, request, CusInfo.class);
	}
	
	
	
	@Override protected DeciTree<CusInfo> getDecisionTreeHook(DeciTreeOption<CusInfo> option) {
		return new RootCusInsertUser(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
