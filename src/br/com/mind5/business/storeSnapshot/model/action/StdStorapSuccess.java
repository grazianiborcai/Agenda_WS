package br.com.mind5.business.storeSnapshot.model.action;

import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStorapSuccess extends ActionStdSuccessTemplate<StorapInfo> {
	public StdStorapSuccess(DeciTreeOption<StorapInfo> option) {
		super(option);
	}
}
