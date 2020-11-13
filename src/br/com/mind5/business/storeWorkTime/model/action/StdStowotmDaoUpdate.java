package br.com.mind5.business.storeWorkTime.model.action;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStowotmDaoUpdate extends ActionStdTemplate<StowotmInfo> {

	public StdStowotmDaoUpdate(DeciTreeOption<StowotmInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StowotmInfo> buildVisitorHook(DeciTreeOption<StowotmInfo> option) {
		return new VisiStowotmDaoUpdate(option);
	}
}
