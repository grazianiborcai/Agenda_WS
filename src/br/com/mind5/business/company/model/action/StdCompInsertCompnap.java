package br.com.mind5.business.company.model.action;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCompInsertCompnap extends ActionStdTemplate<CompInfo> {

	public StdCompInsertCompnap(DeciTreeOption<CompInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CompInfo> buildVisitorHook(DeciTreeOption<CompInfo> option) {
		return new VisiCompInsertCompnap(option);
	}
}
