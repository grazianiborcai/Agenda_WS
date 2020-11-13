package br.com.mind5.business.company.model.action;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class StdCompMergeUsername extends ActionStdTemplate<CompInfo> {

	public StdCompMergeUsername(DeciTreeOption<CompInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CompInfo> buildVisitorHook(DeciTreeOption<CompInfo> option) {
		return new VisiCompMergeUsername(option);
	}
}
