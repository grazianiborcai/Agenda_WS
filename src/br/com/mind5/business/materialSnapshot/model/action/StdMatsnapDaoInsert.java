package br.com.mind5.business.materialSnapshot.model.action;

import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatsnapDaoInsert extends ActionStdTemplateV2<MatsnapInfo> {

	public StdMatsnapDaoInsert(DeciTreeOption<MatsnapInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<MatsnapInfo> buildVisitorHook(DeciTreeOption<MatsnapInfo> option) {
		return new VisiMatsnapDaoInsert(option);
	}
}