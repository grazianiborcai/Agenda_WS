package br.com.mind5.masterData.refundPolicyGroupItemSearch.model.action;

import br.com.mind5.masterData.refundPolicyGroupItemSearch.info.RefugritarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdRefugritarchDaoSelect extends ActionStdTemplateV2<RefugritarchInfo> {

	public StdRefugritarchDaoSelect(DeciTreeOption<RefugritarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<RefugritarchInfo> buildVisitorHook(DeciTreeOption<RefugritarchInfo> option) {
		return new VisiRefugritarchDaoSelect(option);
	}
}
