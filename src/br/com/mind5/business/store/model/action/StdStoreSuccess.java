package br.com.mind5.business.store.model.action;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStoreSuccess extends ActionStdSuccessTemplate<StoreInfo> {
	public StdStoreSuccess(DeciTreeOption<StoreInfo> option) {
		super(option);
	}
}
