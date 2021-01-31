package br.com.mind5.business.home.model.action;

import br.com.mind5.business.home.info.HomeInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdHomeMergeUsername extends ActionStdTemplate<HomeInfo> {

	public StdHomeMergeUsername(DeciTreeOption<HomeInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<HomeInfo> buildVisitorHook(DeciTreeOption<HomeInfo> option) {
		return new VisiHomeMergeUsername(option);
	}
}
