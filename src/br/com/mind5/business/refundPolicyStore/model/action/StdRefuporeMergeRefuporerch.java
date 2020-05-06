package br.com.mind5.business.refundPolicyStore.model.action;

import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdRefuporeMergeRefuporerch extends ActionStdTemplateV2<RefuporeInfo> {

	public StdRefuporeMergeRefuporerch(DeciTreeOption<RefuporeInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<RefuporeInfo> buildVisitorHook(DeciTreeOption<RefuporeInfo> option) {
		return new VisiRefuporeMergeRefuporerch(option);
	}
}
