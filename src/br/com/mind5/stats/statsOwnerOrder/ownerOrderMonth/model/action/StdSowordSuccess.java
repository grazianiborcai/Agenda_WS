package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.model.action;

import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.info.SowordInfo;

public final class StdSowordSuccess extends ActionStdSuccessTemplate<SowordInfo> {
	
	public StdSowordSuccess(DeciTreeOption<SowordInfo> option) {
		super(option);
	}
}
