package br.com.mind5.business.refundPolicy.model.action;

import br.com.mind5.business.refundPolicy.info.RefupolInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public class StdRefupolSuccess extends ActionStdSuccessTemplate<RefupolInfo> {
	
	public StdRefupolSuccess(DeciTreeOption<RefupolInfo> option) {
		super(option);
	}
}
