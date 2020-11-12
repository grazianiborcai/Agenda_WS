package br.com.mind5.business.feeDefault.model.action;

import br.com.mind5.business.feeDefault.info.FeedefInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFeedefDaoSelect extends ActionStdTemplateV2<FeedefInfo> {

	public StdFeedefDaoSelect(DeciTreeOption<FeedefInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<FeedefInfo> buildVisitorHook(DeciTreeOption<FeedefInfo> option) {
		return new VisiFeedefDaoSelect(option);
	}
}
