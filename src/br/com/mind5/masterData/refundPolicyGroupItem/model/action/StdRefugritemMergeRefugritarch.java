package br.com.mind5.masterData.refundPolicyGroupItem.model.action;

import br.com.mind5.masterData.refundPolicyGroupItem.info.RefugritemInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdRefugritemMergeRefugritarch extends ActionStdTemplateV2<RefugritemInfo> {

	public StdRefugritemMergeRefugritarch(DeciTreeOption<RefugritemInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<RefugritemInfo> buildVisitorHook(DeciTreeOption<RefugritemInfo> option) {
		return new VisiRefugritemMergeRefugritarch(option);
	}
}
