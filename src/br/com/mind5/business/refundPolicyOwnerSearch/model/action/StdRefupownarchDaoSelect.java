package br.com.mind5.business.refundPolicyOwnerSearch.model.action;

import br.com.mind5.business.refundPolicyOwnerSearch.info.RefupownarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdRefupownarchDaoSelect extends ActionStdTemplateV2<RefupownarchInfo> {

	public StdRefupownarchDaoSelect(DeciTreeOption<RefupownarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<RefupownarchInfo> buildVisitorHook(DeciTreeOption<RefupownarchInfo> option) {
		return new VisiRefupownarchDaoSelect(option);
	}
}
