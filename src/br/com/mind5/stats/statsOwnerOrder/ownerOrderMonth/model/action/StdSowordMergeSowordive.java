package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.info.SowordInfo;

public final class StdSowordMergeSowordive extends ActionStdTemplate<SowordInfo> {

	public StdSowordMergeSowordive(DeciTreeOption<SowordInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SowordInfo> buildVisitorHook(DeciTreeOption<SowordInfo> option) {
		return new VisiSowordMergeSowordiveMonth(option);
	}
}
