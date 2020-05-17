package br.com.mind5.masterData.refundPolicyGroup.model.action;

import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdRefugroupDaoSelect extends ActionStdTemplateV2<RefugroupInfo> {

	public StdRefugroupDaoSelect(DeciTreeOption<RefugroupInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<RefugroupInfo> buildVisitorHook(DeciTreeOption<RefugroupInfo> option) {
		return new VisiRefugroupDaoSelect(option);
	}
}
