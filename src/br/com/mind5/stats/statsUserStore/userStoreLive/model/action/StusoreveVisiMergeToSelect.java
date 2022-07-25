package br.com.mind5.stats.statsUserStore.userStoreLive.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserStore.userStoreLive.info.StusoreveInfo;
import br.com.mind5.stats.statsUserStore.userStoreLive.info.StusoreveMerger;

public final class StusoreveVisiMergeToSelect extends ActionVisitorTemplateMerge<StusoreveInfo, StusoreveInfo> {
	
	public StusoreveVisiMergeToSelect(DeciTreeOption<StusoreveInfo> option) {
		super(option, StusoreveInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<StusoreveInfo>> getVisitorClassHook() {
		return StusoreveVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<StusoreveInfo> mergeHook(List<StusoreveInfo> baseInfos, List<StusoreveInfo> selectedInfos) {	
		return StusoreveMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
