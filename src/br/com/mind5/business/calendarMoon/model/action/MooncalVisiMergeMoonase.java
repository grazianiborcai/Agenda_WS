package br.com.mind5.business.calendarMoon.model.action;

import java.util.List;

import br.com.mind5.business.calendarMoon.info.MooncalInfo;
import br.com.mind5.business.calendarMoon.info.MooncalMerger;
import br.com.mind5.masterData.moonPhase.info.MoonaseInfo;
import br.com.mind5.masterData.moonPhase.model.decisionTree.MoonaseRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MooncalVisiMergeMoonase extends ActionVisitorTemplateMerge<MooncalInfo, MoonaseInfo> {
	
	public MooncalVisiMergeMoonase(DeciTreeOption<MooncalInfo> option) {
		super(option, MoonaseInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MoonaseInfo>> getTreeClassHook() {
		return MoonaseRootSelect.class;
	}
	
	
	
	@Override protected List<MooncalInfo> mergeHook(List<MooncalInfo> baseInfos, List<MoonaseInfo> selectedInfos) {	
		return MooncalMerger.mergeWithMoonase(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
