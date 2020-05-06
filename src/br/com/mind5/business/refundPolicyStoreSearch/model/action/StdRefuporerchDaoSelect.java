package br.com.mind5.business.refundPolicyStoreSearch.model.action;

import br.com.mind5.business.refundPolicyStoreSearch.info.RefuporerchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdRefuporerchDaoSelect extends ActionStdTemplateV2<RefuporerchInfo> {

	public StdRefuporerchDaoSelect(DeciTreeOption<RefuporerchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<RefuporerchInfo> buildVisitorHook(DeciTreeOption<RefuporerchInfo> option) {
		return new VisiRefuporerchDaoSelect(option);
	}
}
