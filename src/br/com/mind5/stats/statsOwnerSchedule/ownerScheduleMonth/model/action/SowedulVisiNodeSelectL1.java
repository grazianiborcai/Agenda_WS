package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.info.SowedulInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.model.decisionTree.SowedulNodeSelectL1;

public final class SowedulVisiNodeSelectL1 extends ActionVisitorTemplateAction<SowedulInfo, SowedulInfo> {

	public SowedulVisiNodeSelectL1(DeciTreeOption<SowedulInfo> option) {
		super(option, SowedulInfo.class, SowedulInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowedulInfo>> getTreeClassHook() {
		return SowedulNodeSelectL1.class;
	}
	
	
	
	@Override protected List<SowedulInfo> toBaseClassHook(List<SowedulInfo> baseInfos, List<SowedulInfo> results) {
		return results;
	}
}
