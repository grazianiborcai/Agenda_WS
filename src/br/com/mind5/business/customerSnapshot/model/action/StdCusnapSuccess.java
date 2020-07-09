package br.com.mind5.business.customerSnapshot.model.action;

import br.com.mind5.business.customerSnapshot.info.CusnapInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCusnapSuccess extends ActionStdSuccessTemplate<CusnapInfo> {
	
	public StdCusnapSuccess(DeciTreeOption<CusnapInfo> option) {
		super(option);
	}
}
