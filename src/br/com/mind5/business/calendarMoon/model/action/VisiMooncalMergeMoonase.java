package br.com.mind5.business.calendarMoon.model.action;

import java.util.List;

import br.com.mind5.business.calendarMoon.info.MooncalInfo;
import br.com.mind5.business.calendarMoon.info.MooncalMerger;
import br.com.mind5.masterData.moonPhase.info.MoonaseInfo;
import br.com.mind5.masterData.moonPhase.model.decisionTree.RootMoonaseSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMooncalMergeMoonase extends ActionVisitorTemplateMergeV2<MooncalInfo, MoonaseInfo> {
	
	public VisiMooncalMergeMoonase(DeciTreeOption<MooncalInfo> option) {
		super(option, MoonaseInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MoonaseInfo>> getTreeClassHook() {
		return RootMoonaseSelect.class;
	}
	
	
	
	@Override protected List<MooncalInfo> mergeHook(List<MooncalInfo> baseInfos, List<MoonaseInfo> selectedInfos) {	
		return MooncalMerger.mergeWithMoonase(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.MERGE_WHEN_EMPTY;
	}
}
