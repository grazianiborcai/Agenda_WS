package br.com.mind5.payment.creditCard.model;

import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.model.decisionTree.CrecardRootDelete;


public final class CrecardModelDelete extends ModelTemplate<CrecardInfo> {

	public CrecardModelDelete(CrecardInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<CrecardInfo> getDecisionTreeHook(DeciTreeOption<CrecardInfo> option) {
		return new CrecardRootDelete(option);
	}
}
