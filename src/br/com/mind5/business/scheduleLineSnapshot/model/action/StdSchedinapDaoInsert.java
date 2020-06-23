package br.com.mind5.business.scheduleLineSnapshot.model.action;

import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchedinapDaoInsert extends ActionStdTemplateV2<SchedinapInfo> {

	public StdSchedinapDaoInsert(DeciTreeOption<SchedinapInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<SchedinapInfo> buildVisitorHook(DeciTreeOption<SchedinapInfo> option) {
		return new VisiSchedinapDaoInsert(option);
	}
}
