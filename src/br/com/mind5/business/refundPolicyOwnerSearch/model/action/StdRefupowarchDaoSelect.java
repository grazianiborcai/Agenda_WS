package br.com.mind5.business.refundPolicyOwnerSearch.model.action;

import br.com.mind5.business.refundPolicyOwnerSearch.info.RefupowarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdRefupowarchDaoSelect extends ActionStdTemplateV2<RefupowarchInfo> {

	public StdRefupowarchDaoSelect(DeciTreeOption<RefupowarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<RefupowarchInfo> buildVisitorHook(DeciTreeOption<RefupowarchInfo> option) {
		return new VisiRefupowarchDaoSelect(option);
	}
}
