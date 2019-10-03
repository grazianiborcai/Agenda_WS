package br.com.gda.business.store.model.action;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.model.action.commom.ActionStdSuccessTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdStoreSuccess extends ActionStdSuccessTemplate<StoreInfo> {
	public StdStoreSuccess(DeciTreeOption<StoreInfo> option) {
		super(option);
	}
}
