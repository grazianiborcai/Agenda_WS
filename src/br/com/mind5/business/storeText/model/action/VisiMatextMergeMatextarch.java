package br.com.mind5.business.storeText.model.action;

import java.util.List;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeText.info.StorextMerger;
import br.com.mind5.business.materialTextSearch.info.MatextarchCopier;
import br.com.mind5.business.materialTextSearch.info.MatextarchInfo;
import br.com.mind5.business.materialTextSearch.model.decisionTree.RootMatextarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatextMergeMatextarch extends ActionVisitorTemplateMergeV2<StorextInfo, MatextarchInfo> {
	
	public VisiMatextMergeMatextarch(DeciTreeOption<StorextInfo> option) {
		super(option, MatextarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatextarchInfo>> getTreeClassHook() {
		return RootMatextarchSelect.class;
	}
	
	
	
	@Override protected List<MatextarchInfo> toActionClassHook(List<StorextInfo> baseInfos) {
		return MatextarchCopier.copyFromMatext(baseInfos);	
	}
	
	
	
	@Override protected List<StorextInfo> mergeHook(List<StorextInfo> baseInfos, List<MatextarchInfo> selectedInfos) {	
		return StorextMerger.mergeWithMatextarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
