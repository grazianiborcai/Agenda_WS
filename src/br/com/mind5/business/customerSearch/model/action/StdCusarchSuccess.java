package br.com.mind5.business.customerSearch.model.action;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCusarchSuccess extends ActionStdSuccessTemplate<CusarchInfo> {
	
	public StdCusarchSuccess(DeciTreeOption<CusarchInfo> option) {
		super(option);
	}
}
