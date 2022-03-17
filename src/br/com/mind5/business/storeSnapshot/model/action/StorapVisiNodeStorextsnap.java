package br.com.mind5.business.storeSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.business.storeSnapshot.model.decisionTree.StorapNodeStorextsnap;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorapVisiNodeStorextsnap extends ActionVisitorTemplateAction<StorapInfo, StorapInfo> {

	public StorapVisiNodeStorextsnap(DeciTreeOption<StorapInfo> option) {
		super(option, StorapInfo.class, StorapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StorapInfo>> getTreeClassHook() {
		return StorapNodeStorextsnap.class;
	}
	
	
	
	@Override protected List<StorapInfo> toBaseClassHook(List<StorapInfo> baseInfos, List<StorapInfo> results) {
		return results;
	}
}
