package br.com.mind5.masterData.refundPolicy.model.action;

import br.com.mind5.masterData.refundPolicy.info.RefupoInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdRefupoDaoSelect extends ActionStdTemplate<RefupoInfo> {

	public StdRefupoDaoSelect(DeciTreeOption<RefupoInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<RefupoInfo> buildVisitorHook(DeciTreeOption<RefupoInfo> option) {
		return new VisiRefupoDaoSelect(option);
	}
}
