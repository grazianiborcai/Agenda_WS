package br.com.mind5.stats.statsOwnerSale.ownerSale.model.action;

import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSale.ownerSale.info.SowalInfo;

public final class StdSowalSuccess extends ActionStdSuccessTemplate<SowalInfo> {
	
	public StdSowalSuccess(DeciTreeOption<SowalInfo> option) {
		super(option);
	}
}
