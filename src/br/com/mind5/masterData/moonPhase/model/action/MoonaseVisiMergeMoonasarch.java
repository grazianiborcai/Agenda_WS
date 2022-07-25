package br.com.mind5.masterData.moonPhase.model.action;

import java.util.List;

import br.com.mind5.masterData.moonPhase.info.MoonaseInfo;
import br.com.mind5.masterData.moonPhase.info.MoonaseMerger;
import br.com.mind5.masterData.moonPhaseSearch.info.MoonasarchInfo;
import br.com.mind5.masterData.moonPhaseSearch.model.decisionTree.RootMoonasarchSelect;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MoonaseVisiMergeMoonasarch extends ActionVisitorTemplateMerge<MoonaseInfo, MoonasarchInfo> {
	
	public MoonaseVisiMergeMoonasarch(DeciTreeOption<MoonaseInfo> option) {
		super(option, MoonasarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MoonasarchInfo>> getTreeClassHook() {
		return RootMoonasarchSelect.class;
	}
	
	
	
	@Override protected List<MoonaseInfo> mergeHook(List<MoonaseInfo> baseInfos, List<MoonasarchInfo> selectedInfos) {	
		return MoonaseMerger.mergeWithMoonasarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
