package br.com.mind5.masterData.refundPolicyGroupHeader.model.action;

import br.com.mind5.masterData.refundPolicyGroupHeader.info.RefugraderInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdRefugraderDaoSelect extends ActionStdTemplateV2<RefugraderInfo> {

	public StdRefugraderDaoSelect(DeciTreeOption<RefugraderInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<RefugraderInfo> buildVisitorHook(DeciTreeOption<RefugraderInfo> option) {
		return new VisiRefugraderDaoSelect(option);
	}
}
