package br.com.mind5.masterData.dayParting.model.action;

import java.util.List;

import br.com.mind5.masterData.dayParting.info.DaypartInfo;
import br.com.mind5.masterData.dayParting.info.DaypartMerger;
import br.com.mind5.masterData.dayPartingSearch.info.DayparchInfo;
import br.com.mind5.masterData.dayPartingSearch.model.decisionTree.RootDayparchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiDaypartMergeDayparch extends ActionVisitorTemplateMergeV2<DaypartInfo, DayparchInfo> {
	
	public VisiDaypartMergeDayparch(DeciTreeOption<DaypartInfo> option) {
		super(option, DayparchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<DayparchInfo>> getTreeClassHook() {
		return RootDayparchSelect.class;
	}
	
	
	
	@Override protected List<DaypartInfo> mergeHook(List<DaypartInfo> baseInfos, List<DayparchInfo> selectedInfos) {	
		return DaypartMerger.mergeWithDayparch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
