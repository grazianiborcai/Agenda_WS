package br.com.mind5.business.owner.model.action;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOwnerCompInsert extends ActionStdTemplateV2<OwnerInfo> {

	public StdOwnerCompInsert(DeciTreeOption<OwnerInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<OwnerInfo> buildVisitorHook(DeciTreeOption<OwnerInfo> option) {
		return new VisiOwnerCompInsert(option);
	}
}