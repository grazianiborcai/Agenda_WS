package br.com.mind5.payment.creditCard.model.action;

import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

public final class StdCrecardSuccess extends ActionStdSuccessTemplate<CrecardInfo> {
	public StdCrecardSuccess(DeciTreeOption<CrecardInfo> option) {
		super(option);
	}
}
