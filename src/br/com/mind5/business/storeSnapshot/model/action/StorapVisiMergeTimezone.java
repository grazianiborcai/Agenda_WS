package br.com.mind5.business.storeSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.business.storeSnapshot.info.StorapMerger;
import br.com.mind5.masterData.timezone.info.TimezoneInfo;
import br.com.mind5.masterData.timezone.model.decisionTree.TimezoneRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorapVisiMergeTimezone extends ActionVisitorTemplateMerge<StorapInfo, TimezoneInfo> {
	
	public StorapVisiMergeTimezone(DeciTreeOption<StorapInfo> option) {
		super(option, TimezoneInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<TimezoneInfo>> getTreeClassHook() {
		return TimezoneRootSelect.class;
	}
	
	
	
	@Override protected List<StorapInfo> mergeHook(List<StorapInfo> baseInfos, List<TimezoneInfo> selectedInfos) {	
		return StorapMerger.mergeWithTimezone(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
