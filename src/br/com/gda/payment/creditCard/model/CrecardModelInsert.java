package br.com.gda.payment.creditCard.model;

import javax.servlet.http.HttpServletRequest;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.creditCard.info.CrecardInfo;
import br.com.gda.payment.creditCard.model.decisionTree.RootCrecardInsert;


public final class CrecardModelInsert extends ModelTemplate<CrecardInfo> {

	public CrecardModelInsert(String incomingData, HttpServletRequest request) {
		super(incomingData, request, CrecardInfo.class);
	}
	
	
	
	@Override protected DeciTree<CrecardInfo> getDecisionTreeHook(DeciTreeOption<CrecardInfo> option) {
		return new RootCrecardInsert(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
