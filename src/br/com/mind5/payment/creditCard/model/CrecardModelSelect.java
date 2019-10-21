package br.com.mind5.payment.creditCard.model;

import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.model.decisionTree.RootCrecardSelect;


public final class CrecardModelSelect extends ModelTemplate<CrecardInfo> {

	public CrecardModelSelect(CrecardInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<CrecardInfo> getDecisionTreeHook(DeciTreeOption<CrecardInfo> option) {
		return new RootCrecardSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
