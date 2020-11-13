package br.com.mind5.business.orderItemSnapshot.model.action;

import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public class StdOrdemrapSuccess extends ActionStdSuccessTemplate<OrdemrapInfo> {
	
	public StdOrdemrapSuccess(DeciTreeOption<OrdemrapInfo> option) {
		super(option);
	}
}
