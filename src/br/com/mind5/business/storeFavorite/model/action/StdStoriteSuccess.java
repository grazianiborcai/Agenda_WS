package br.com.mind5.business.storeFavorite.model.action;

import br.com.mind5.business.storeFavorite.info.StoriteInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStoriteSuccess extends ActionStdSuccessTemplate<StoriteInfo> {
	public StdStoriteSuccess(DeciTreeOption<StoriteInfo> option) {
		super(option);
	}
}
