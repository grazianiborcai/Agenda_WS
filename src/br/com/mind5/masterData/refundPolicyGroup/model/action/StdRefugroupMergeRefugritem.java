package br.com.mind5.masterData.refundPolicyGroup.model.action;

import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdRefugroupMergeRefugritem extends ActionStdTemplateV2<RefugroupInfo> {

	public StdRefugroupMergeRefugritem(DeciTreeOption<RefugroupInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<RefugroupInfo> buildVisitorHook(DeciTreeOption<RefugroupInfo> option) {
		return new VisiRefugroupMergeRefugritem(option);
	}
}