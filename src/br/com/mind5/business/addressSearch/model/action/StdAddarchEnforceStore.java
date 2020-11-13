package br.com.mind5.business.addressSearch.model.action;

import br.com.mind5.business.addressSearch.info.AddarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdAddarchEnforceStore extends ActionStdTemplate<AddarchInfo> {

	public StdAddarchEnforceStore(DeciTreeOption<AddarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<AddarchInfo> buildVisitorHook(DeciTreeOption<AddarchInfo> option) {
		return new VisiAddarchEnforceStore(option);
	}
}
