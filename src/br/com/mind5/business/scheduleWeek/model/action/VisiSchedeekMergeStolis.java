package br.com.mind5.business.scheduleWeek.model.action;

import java.util.List;

import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.business.scheduleWeek.info.SchedeekMerger;
import br.com.mind5.business.storeList.info.StolisCopier;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.business.storeList.model.decisionTree.RootStolisSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedeekMergeStolis extends ActionVisitorTemplateMergeV2<SchedeekInfo, StolisInfo> {
	
	public VisiSchedeekMergeStolis(DeciTreeOption<SchedeekInfo> option) {
		super(option, StolisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StolisInfo>> getTreeClassHook() {
		return RootStolisSelect.class;
	}
	
	
	
	@Override protected List<StolisInfo> toActionClassHook(List<SchedeekInfo> baseInfos) {
		return StolisCopier.copyFromSchedeek(baseInfos);
	}
	
	
	
	@Override protected List<SchedeekInfo> mergeHook(List<SchedeekInfo> baseInfos, List<StolisInfo> selectedInfos) {	
		return SchedeekMerger.mergeWithStolis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
