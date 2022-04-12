package br.com.mind5.business.calendarTimeStore.model.action;

import java.util.List;

import br.com.mind5.business.calendarTimeStore.info.CalimoreInfo;
import br.com.mind5.business.calendarTimeStore.info.CalimoreMerger;
import br.com.mind5.business.storeLeaveDateRange.info.StolargCopier;
import br.com.mind5.business.storeLeaveDateRange.info.StolargInfo;
import br.com.mind5.business.storeLeaveDateRange.model.decisionTree.StolargRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CalimoreVisiMergeStolarg extends ActionVisitorTemplateMerge<CalimoreInfo, StolargInfo> {
	
	public CalimoreVisiMergeStolarg(DeciTreeOption<CalimoreInfo> option) {
		super(option, StolargInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StolargInfo>> getTreeClassHook() {
		return StolargRootSelect.class;
	}
	
	
	
	@Override protected List<StolargInfo> toActionClassHook(List<CalimoreInfo> baseInfos) {
		return StolargCopier.copyFromCalimore(baseInfos);	
	}
	
	
	
	@Override protected List<CalimoreInfo> mergeHook(List<CalimoreInfo> baseInfos, List<StolargInfo> selectedInfos) {	
		return CalimoreMerger.mergeWithStolarg(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
