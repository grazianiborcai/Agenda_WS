package br.com.mind5.business.storeAccount.model.action;

import java.util.List;

import br.com.mind5.business.storeAccount.info.StoracInfo;
import br.com.mind5.business.storeAccount.model.decisionTree.StoracNodeSelectL1;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoracVisiNodeSelectL1 extends ActionVisitorTemplateAction<StoracInfo, StoracInfo> {

	public StoracVisiNodeSelectL1(DeciTreeOption<StoracInfo> option) {
		super(option, StoracInfo.class, StoracInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoracInfo>> getTreeClassHook() {
		return StoracNodeSelectL1.class;
	}
	
	
	
	@Override protected List<StoracInfo> toBaseClassHook(List<StoracInfo> baseInfos, List<StoracInfo> results) {
		return results;
	}
}
