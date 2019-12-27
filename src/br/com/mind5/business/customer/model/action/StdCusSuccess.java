package br.com.mind5.business.customer.model.action;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCusSuccess extends ActionStdSuccessTemplate<CusInfo> {
	
	public StdCusSuccess(DeciTreeOption<CusInfo> option) {
		super(option);
	}
}
