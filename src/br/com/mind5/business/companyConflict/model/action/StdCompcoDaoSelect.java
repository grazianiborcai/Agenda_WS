package br.com.mind5.business.companyConflict.model.action;

import br.com.mind5.business.companyConflict.info.CompcoInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCompcoDaoSelect extends ActionStdTemplate<CompcoInfo> {

	public StdCompcoDaoSelect(DeciTreeOption<CompcoInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CompcoInfo> buildVisitorHook(DeciTreeOption<CompcoInfo> option) {
		return new VisiCompcoDaoSelect(option);
	}
}
