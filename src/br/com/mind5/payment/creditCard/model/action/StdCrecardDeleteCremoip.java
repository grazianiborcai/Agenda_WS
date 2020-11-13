package br.com.mind5.payment.creditCard.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

public final class StdCrecardDeleteCremoip extends ActionStdTemplate<CrecardInfo> {

	public StdCrecardDeleteCremoip(DeciTreeOption<CrecardInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CrecardInfo> buildVisitorHook(DeciTreeOption<CrecardInfo> option) {
		return new VisiCrecardDeleteCremoip(option);
	}
}
