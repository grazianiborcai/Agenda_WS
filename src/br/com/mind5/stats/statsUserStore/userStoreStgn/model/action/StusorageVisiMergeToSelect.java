package br.com.mind5.stats.statsUserStore.userStoreStgn.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserStore.userStoreStgn.info.StusorageInfo;
import br.com.mind5.stats.statsUserStore.userStoreStgn.info.StusorageMerger;

public final class StusorageVisiMergeToSelect extends ActionVisitorTemplateMerge<StusorageInfo, StusorageInfo> {
	
	public StusorageVisiMergeToSelect(DeciTreeOption<StusorageInfo> option) {
		super(option, StusorageInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<StusorageInfo>> getVisitorClassHook() {
		return StusorageVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<StusorageInfo> mergeHook(List<StusorageInfo> baseInfos, List<StusorageInfo> selectedInfos) {	
		return StusorageMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
