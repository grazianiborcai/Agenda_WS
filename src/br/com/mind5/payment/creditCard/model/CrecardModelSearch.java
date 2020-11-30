package br.com.mind5.payment.creditCard.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.model.decisionTree.RootCrecardSearch;


public final class CrecardModelSearch extends ModelTemplate<CrecardInfo> {

	public CrecardModelSearch(String incomingData, HttpServletRequest request) {
		super(incomingData, request, CrecardInfo.class);
	}
	
	
	
	@Override protected DeciTree<CrecardInfo> getDecisionTreeHook(DeciTreeOption<CrecardInfo> option) {
		return new RootCrecardSearch(option);
	}
}
