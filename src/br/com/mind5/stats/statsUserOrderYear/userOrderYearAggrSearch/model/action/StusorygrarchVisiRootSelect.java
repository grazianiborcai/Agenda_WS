package br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.info.StusorygrarchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.model.decisionTree.StusorygrarchRootSelect;

public final class StusorygrarchVisiRootSelect extends ActionVisitorTemplateAction<StusorygrarchInfo, StusorygrarchInfo> {

	public StusorygrarchVisiRootSelect(DeciTreeOption<StusorygrarchInfo> option) {
		super(option, StusorygrarchInfo.class, StusorygrarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StusorygrarchInfo>> getTreeClassHook() {
		return StusorygrarchRootSelect.class;
	}
	
	
	
	@Override protected List<StusorygrarchInfo> toBaseClassHook(List<StusorygrarchInfo> baseInfos, List<StusorygrarchInfo> results) {
		return results;
	}
}
