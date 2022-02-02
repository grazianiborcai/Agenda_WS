package br.com.mind5.stats.statsStoreAccount.storeAccount.model.action;

import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreAccount.storeAccount.info.StoracInfo;

public final class StdStoracSuccess extends ActionStdSuccessTemplate<StoracInfo> {
	
	public StdStoracSuccess(DeciTreeOption<StoracInfo> option) {
		super(option);
	}
}
