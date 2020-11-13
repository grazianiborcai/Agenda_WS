package br.com.mind5.message.emailScheduleConfirmation.model.action;

import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.business.storeList.model.decisionTree.RootStolisSelect;
import br.com.mind5.message.emailScheduleConfirmation.info.EmulonInfo;
import br.com.mind5.message.emailScheduleConfirmation.info.EmulonMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmulonMergeStolis extends ActionVisitorTemplateMerge<EmulonInfo, StolisInfo> {
	
	public VisiEmulonMergeStolis(DeciTreeOption<EmulonInfo> option) {
		super(option, StolisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StolisInfo>> getTreeClassHook() {
		return RootStolisSelect.class;
	}
	
	
	
	@Override protected List<EmulonInfo> mergeHook(List<EmulonInfo> baseInfos, List<StolisInfo> selectedInfos) {	
		return EmulonMerger.mergeWithStolis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
