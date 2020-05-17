package br.com.mind5.masterData.refundPolicyGroupSearch.model.action;

import br.com.mind5.masterData.refundPolicyGroupSearch.info.RefugrarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdRefugrarchDaoSelect extends ActionStdTemplateV2<RefugrarchInfo> {

	public StdRefugrarchDaoSelect(DeciTreeOption<RefugrarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<RefugrarchInfo> buildVisitorHook(DeciTreeOption<RefugrarchInfo> option) {
		return new VisiRefugrarchDaoSelect(option);
	}
}
