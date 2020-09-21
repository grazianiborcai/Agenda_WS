package br.com.mind5.business.storeText.model.action;

import java.util.List;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeText.info.StorextMerger;
import br.com.mind5.business.materialTextDefault.info.MatextaultInfo;
import br.com.mind5.business.materialTextDefault.model.decisionTree.RootMatextaultSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatextMergeMatextault extends ActionVisitorTemplateMergeV2<StorextInfo, MatextaultInfo> {
	
	public VisiMatextMergeMatextault(DeciTreeOption<StorextInfo> option) {
		super(option, MatextaultInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatextaultInfo>> getTreeClassHook() {
		return RootMatextaultSelect.class;
	}
	
	
	
	@Override protected List<StorextInfo> mergeHook(List<StorextInfo> baseInfos, List<MatextaultInfo> selectedInfos) {	
		return StorextMerger.mergeWithMatextault(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
