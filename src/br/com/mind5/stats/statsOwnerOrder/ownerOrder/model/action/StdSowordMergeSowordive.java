package br.com.mind5.stats.statsOwnerOrder.ownerOrder.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrder.info.SowordInfo;

public final class StdSowordMergeSowordive extends ActionStdTemplate<SowordInfo> {

	public StdSowordMergeSowordive(DeciTreeOption<SowordInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SowordInfo> buildVisitorHook(DeciTreeOption<SowordInfo> option) {
		return new VisiSowordMergeSowordive(option);
	}
}
