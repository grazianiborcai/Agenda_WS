package br.com.mind5.business.addressDefault.model.action;

import br.com.mind5.business.addressDefault.info.AddaultInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdAddaultMergeToSelect extends ActionStdTemplate<AddaultInfo> {

	public StdAddaultMergeToSelect(DeciTreeOption<AddaultInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<AddaultInfo> buildVisitorHook(DeciTreeOption<AddaultInfo> option) {
		return new VisiAddaultMergeToSelect(option);
	}
}
