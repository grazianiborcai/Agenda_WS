package br.com.mind5.business.storeText.model.action;

import java.util.List;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeText.info.StorextMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStorextMergeToUpdate extends ActionVisitorTemplateMergeV2<StorextInfo, StorextInfo> {
	
	public VisiStorextMergeToUpdate(DeciTreeOption<StorextInfo> option) {
		super(option, StorextInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<StorextInfo>> getActionClassHook() {
		return StdStorextDaoSelect.class;
	}
	
	
	
	@Override protected List<StorextInfo> mergeHook(List<StorextInfo> baseInfos, List<StorextInfo> selectedInfos) {	
		return StorextMerger.mergeToUpdate(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
