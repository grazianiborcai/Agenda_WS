package br.com.mind5.stats.statsUserOrderYear.userOrderYear.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYear.info.StusoryInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYear.model.decisionTree.StusoryRootSelect;

public final class StusoryVisiRootSelect extends ActionVisitorTemplateAction<StusoryInfo, StusoryInfo> {

	public StusoryVisiRootSelect(DeciTreeOption<StusoryInfo> option) {
		super(option, StusoryInfo.class, StusoryInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StusoryInfo>> getTreeClassHook() {
		return StusoryRootSelect.class;
	}
	
	
	
	@Override protected List<StusoryInfo> toBaseClassHook(List<StusoryInfo> baseInfos, List<StusoryInfo> results) {
		return results;
	}
}
