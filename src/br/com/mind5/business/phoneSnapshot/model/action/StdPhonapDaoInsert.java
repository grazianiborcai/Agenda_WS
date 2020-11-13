package br.com.mind5.business.phoneSnapshot.model.action;

import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPhonapDaoInsert extends ActionStdTemplateV2<PhonapInfo> {

	public StdPhonapDaoInsert(DeciTreeOption<PhonapInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<PhonapInfo> buildVisitorHook(DeciTreeOption<PhonapInfo> option) {
		return new VisiPhonapDaoInsert(option);
	}
}
