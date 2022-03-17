package br.com.mind5.business.storeSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.business.storeTextSnapshot.info.StorextsnapInfo;
import br.com.mind5.business.storeTextSnapshot.model.decisionTree.RootStorextsnapInsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorapVisiStorextsnapInsert extends ActionVisitorTemplateAction<StorapInfo, StorextsnapInfo> {

	public StorapVisiStorextsnapInsert(DeciTreeOption<StorapInfo> option) {
		super(option, StorapInfo.class, StorextsnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StorextsnapInfo>> getTreeClassHook() {
		return RootStorextsnapInsert.class;
	}
	
	
	
	protected List<StorapInfo> toBaseClassHook(List<StorapInfo> baseInfos, List<StorextsnapInfo> results) {
		return baseInfos;
	}
}
