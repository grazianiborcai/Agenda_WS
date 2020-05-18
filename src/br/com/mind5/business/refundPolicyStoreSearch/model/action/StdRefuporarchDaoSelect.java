package br.com.mind5.business.refundPolicyStoreSearch.model.action;

import br.com.mind5.business.refundPolicyStoreSearch.info.RefuporarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdRefuporarchDaoSelect extends ActionStdTemplateV2<RefuporarchInfo> {

	public StdRefuporarchDaoSelect(DeciTreeOption<RefuporarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<RefuporarchInfo> buildVisitorHook(DeciTreeOption<RefuporarchInfo> option) {
		return new VisiRefuporarchDaoSelect(option);
	}
}
