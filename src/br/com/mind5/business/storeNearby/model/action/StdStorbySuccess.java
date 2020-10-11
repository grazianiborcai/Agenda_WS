package br.com.mind5.business.storeNearby.model.action;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStorbySuccess extends ActionStdSuccessTemplate<StorbyInfo> {
	public StdStorbySuccess(DeciTreeOption<StorbyInfo> option) {
		super(option);
	}
}
