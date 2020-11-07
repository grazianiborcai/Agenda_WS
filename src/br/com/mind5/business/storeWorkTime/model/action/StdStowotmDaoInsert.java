package br.com.mind5.business.storeWorkTime.model.action;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStowotmDaoInsert extends ActionStdTemplateV2<StowotmInfo> {

	public StdStowotmDaoInsert(DeciTreeOption<StowotmInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<StowotmInfo> buildVisitorHook(DeciTreeOption<StowotmInfo> option) {
		return new VisiStowotmDaoInsert(option);
	}
}