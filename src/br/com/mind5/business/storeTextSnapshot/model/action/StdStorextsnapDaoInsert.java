package br.com.mind5.business.storeTextSnapshot.model.action;

import br.com.mind5.business.storeTextSnapshot.info.StorextsnapInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStorextsnapDaoInsert extends ActionStdTemplateV2<StorextsnapInfo> {

	public StdStorextsnapDaoInsert(DeciTreeOption<StorextsnapInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<StorextsnapInfo> buildVisitorHook(DeciTreeOption<StorextsnapInfo> option) {
		return new VisiStorextsnapDaoInsert(option);
	}
}
