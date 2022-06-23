package br.com.mind5.stats.statsStoreDashboard.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreDashboard.info.StorashInfo;
import br.com.mind5.stats.statsStoreDashboard.model.decisionTree.StorashRootSelect;

public final class StorashVisiRootSelect extends ActionVisitorTemplateAction<StorashInfo, StorashInfo> {

	public StorashVisiRootSelect(DeciTreeOption<StorashInfo> option) {
		super(option, StorashInfo.class, StorashInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StorashInfo>> getTreeClassHook() {
		return StorashRootSelect.class;
	}
	
	
	
	@Override protected List<StorashInfo> toBaseClassHook(List<StorashInfo> baseInfos, List<StorashInfo> results) {
		return results;
	}
}
