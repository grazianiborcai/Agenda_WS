package br.com.mind5.payment.creditCard.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.model.decisionTree.RootCrecardInsert;


public final class CrecardModelInsert extends ModelTemplate<CrecardInfo> {

	public CrecardModelInsert(String incomingData, HttpServletRequest request) {
		super(incomingData, request, CrecardInfo.class);
	}
	
	
	
	@Override protected DeciTree<CrecardInfo> getDecisionTreeHook(DeciTreeOption<CrecardInfo> option) {
		return new RootCrecardInsert(option);
	}
}
