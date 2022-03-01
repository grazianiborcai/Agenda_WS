package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.info.SowedulInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.model.decisionTree.SowedulNodeUpsertL2;

public final class SowedulVisiNodeUpsertL2 extends ActionVisitorTemplateAction<SowedulInfo, SowedulInfo> {

	public SowedulVisiNodeUpsertL2(DeciTreeOption<SowedulInfo> option) {
		super(option, SowedulInfo.class, SowedulInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowedulInfo>> getTreeClassHook() {
		return SowedulNodeUpsertL2.class;
	}
	
	
	
	@Override protected List<SowedulInfo> toBaseClassHook(List<SowedulInfo> baseInfos, List<SowedulInfo> results) {
		return results;
	}
}
