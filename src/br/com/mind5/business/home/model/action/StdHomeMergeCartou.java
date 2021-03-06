package br.com.mind5.business.home.model.action;

import br.com.mind5.business.home.info.HomeInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdHomeMergeCartou extends ActionStdTemplate<HomeInfo> {

	public StdHomeMergeCartou(DeciTreeOption<HomeInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<HomeInfo> buildVisitorHook(DeciTreeOption<HomeInfo> option) {
		return new VisiHomeMergeCartou(option);
	}
}
