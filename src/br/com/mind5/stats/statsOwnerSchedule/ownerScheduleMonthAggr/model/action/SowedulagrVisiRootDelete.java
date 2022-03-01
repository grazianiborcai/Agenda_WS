package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.info.SowedulagrInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.model.decisionTree.SowedulagrRootDelete;

public final class SowedulagrVisiRootDelete extends ActionVisitorTemplateAction<SowedulagrInfo, SowedulagrInfo> {

	public SowedulagrVisiRootDelete(DeciTreeOption<SowedulagrInfo> option) {
		super(option, SowedulagrInfo.class, SowedulagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowedulagrInfo>> getTreeClassHook() {
		return SowedulagrRootDelete.class;
	}
	
	
	
	@Override protected List<SowedulagrInfo> toBaseClassHook(List<SowedulagrInfo> baseInfos, List<SowedulagrInfo> results) {
		return results;
	}
}
