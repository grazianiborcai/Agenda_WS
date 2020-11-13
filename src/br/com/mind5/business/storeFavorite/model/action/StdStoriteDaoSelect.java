package br.com.mind5.business.storeFavorite.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.business.storeFavorite.info.StoriteInfo;

public final class StdStoriteDaoSelect extends ActionStdTemplate<StoriteInfo> {

	public StdStoriteDaoSelect(DeciTreeOption<StoriteInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StoriteInfo> buildVisitorHook(DeciTreeOption<StoriteInfo> option) {
		return new VisiStoriteDaoSelect(option);
	}
}
