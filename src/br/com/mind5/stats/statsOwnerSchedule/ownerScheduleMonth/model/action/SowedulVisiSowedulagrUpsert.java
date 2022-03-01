package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.info.SowedulInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.info.SowedulMerger;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.info.SowedulagrInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.model.decisionTree.SowedulagrRootUpsert;

public final class SowedulVisiSowedulagrUpsert extends ActionVisitorTemplateAction<SowedulInfo, SowedulagrInfo> {

	public SowedulVisiSowedulagrUpsert(DeciTreeOption<SowedulInfo> option) {
		super(option, SowedulInfo.class, SowedulagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowedulagrInfo>> getTreeClassHook() {
		return SowedulagrRootUpsert.class;
	}
	
	
	
	@Override protected List<SowedulInfo> toBaseClassHook(List<SowedulInfo> baseInfos, List<SowedulagrInfo> results) {
		return SowedulMerger.mergeWithSowedulagr(baseInfos, results);
	}
}
