package br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.info.StusorylirchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.model.decisionTree.StusorylirchRootSelect;

public final class StusorylirchVisiRootSelect extends ActionVisitorTemplateAction<StusorylirchInfo, StusorylirchInfo> {

	public StusorylirchVisiRootSelect(DeciTreeOption<StusorylirchInfo> option) {
		super(option, StusorylirchInfo.class, StusorylirchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StusorylirchInfo>> getTreeClassHook() {
		return StusorylirchRootSelect.class;
	}
	
	
	
	@Override protected List<StusorylirchInfo> toBaseClassHook(List<StusorylirchInfo> baseInfos, List<StusorylirchInfo> results) {
		return results;
	}
}
