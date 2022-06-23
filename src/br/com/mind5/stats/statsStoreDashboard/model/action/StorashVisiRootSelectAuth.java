package br.com.mind5.stats.statsStoreDashboard.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreDashboard.info.StorashInfo;
import br.com.mind5.stats.statsStoreDashboard.model.decisionTree.StorashRootSelectAuth;

public final class StorashVisiRootSelectAuth extends ActionVisitorTemplateAction<StorashInfo, StorashInfo> {

	public StorashVisiRootSelectAuth(DeciTreeOption<StorashInfo> option) {
		super(option, StorashInfo.class, StorashInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StorashInfo>> getTreeClassHook() {
		return StorashRootSelectAuth.class;
	}
	
	
	
	@Override protected List<StorashInfo> toBaseClassHook(List<StorashInfo> baseInfos, List<StorashInfo> results) {
		return results;
	}
}
