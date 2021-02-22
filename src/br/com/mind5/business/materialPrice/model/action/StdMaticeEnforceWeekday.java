package br.com.mind5.business.materialPrice.model.action;

import br.com.mind5.business.materialPrice.info.MaticeInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMaticeEnforceWeekday extends ActionStdTemplate<MaticeInfo> {

	public StdMaticeEnforceWeekday(DeciTreeOption<MaticeInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<MaticeInfo> buildVisitorHook(DeciTreeOption<MaticeInfo> option) {
		return new VisiMaticeEnforceWeekday(option);
	}
}
