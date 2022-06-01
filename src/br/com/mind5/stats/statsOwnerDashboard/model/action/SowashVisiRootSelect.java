package br.com.mind5.stats.statsOwnerDashboard.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerDashboard.info.SowashInfo;
import br.com.mind5.stats.statsOwnerDashboard.model.decisionTree.SowashRootSelect;

public final class SowashVisiRootSelect extends ActionVisitorTemplateAction<SowashInfo, SowashInfo> {

	public SowashVisiRootSelect(DeciTreeOption<SowashInfo> option) {
		super(option, SowashInfo.class, SowashInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowashInfo>> getTreeClassHook() {
		return SowashRootSelect.class;
	}
	
	
	
	@Override protected List<SowashInfo> toBaseClassHook(List<SowashInfo> baseInfos, List<SowashInfo> results) {
		return results;
	}
}
