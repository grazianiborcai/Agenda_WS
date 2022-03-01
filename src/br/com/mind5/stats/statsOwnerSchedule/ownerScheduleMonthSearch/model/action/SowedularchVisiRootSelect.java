package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.info.SowedularchInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.model.decisionTree.SowedularchRootSelect;

public final class SowedularchVisiRootSelect extends ActionVisitorTemplateAction<SowedularchInfo, SowedularchInfo> {

	public SowedularchVisiRootSelect(DeciTreeOption<SowedularchInfo> option) {
		super(option, SowedularchInfo.class, SowedularchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowedularchInfo>> getTreeClassHook() {
		return SowedularchRootSelect.class;
	}
	
	
	
	@Override protected List<SowedularchInfo> toBaseClassHook(List<SowedularchInfo> baseInfos, List<SowedularchInfo> results) {
		return results;
	}
}
