package br.com.mind5.business.companyConflict.model.action;

import br.com.mind5.business.companyConflict.info.CompcoInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCompcoMergeToSelect extends ActionStdTemplate<CompcoInfo> {

	public StdCompcoMergeToSelect(DeciTreeOption<CompcoInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CompcoInfo> buildVisitorHook(DeciTreeOption<CompcoInfo> option) {
		return new VisiCompcoMergeToSelect(option);
	}
}
