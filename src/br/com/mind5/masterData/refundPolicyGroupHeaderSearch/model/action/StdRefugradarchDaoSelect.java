package br.com.mind5.masterData.refundPolicyGroupHeaderSearch.model.action;

import br.com.mind5.masterData.refundPolicyGroupHeaderSearch.info.RefugradarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdRefugradarchDaoSelect extends ActionStdTemplateV2<RefugradarchInfo> {

	public StdRefugradarchDaoSelect(DeciTreeOption<RefugradarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<RefugradarchInfo> buildVisitorHook(DeciTreeOption<RefugradarchInfo> option) {
		return new VisiRefugradarchDaoSelect(option);
	}
}
