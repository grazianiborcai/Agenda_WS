package br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.info.StusorygerchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.model.decisionTree.StusorygerchRootSelect;

public final class StusorygerchVisiRootSelect extends ActionVisitorTemplateAction<StusorygerchInfo, StusorygerchInfo> {

	public StusorygerchVisiRootSelect(DeciTreeOption<StusorygerchInfo> option) {
		super(option, StusorygerchInfo.class, StusorygerchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StusorygerchInfo>> getTreeClassHook() {
		return StusorygerchRootSelect.class;
	}
	
	
	
	@Override protected List<StusorygerchInfo> toBaseClassHook(List<StusorygerchInfo> baseInfos, List<StusorygerchInfo> results) {
		return results;
	}
}
