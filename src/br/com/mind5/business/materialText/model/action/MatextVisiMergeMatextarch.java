package br.com.mind5.business.materialText.model.action;

import java.util.List;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialText.info.MatextMerger;
import br.com.mind5.business.materialTextSearch.info.MatextarchCopier;
import br.com.mind5.business.materialTextSearch.info.MatextarchInfo;
import br.com.mind5.business.materialTextSearch.model.decisionTree.RootMatextarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatextVisiMergeMatextarch extends ActionVisitorTemplateMerge<MatextInfo, MatextarchInfo> {
	
	public MatextVisiMergeMatextarch(DeciTreeOption<MatextInfo> option) {
		super(option, MatextarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatextarchInfo>> getTreeClassHook() {
		return RootMatextarchSelect.class;
	}
	
	
	
	@Override protected List<MatextarchInfo> toActionClassHook(List<MatextInfo> baseInfos) {
		return MatextarchCopier.copyFromMatext(baseInfos);	
	}
	
	
	
	@Override protected List<MatextInfo> mergeHook(List<MatextInfo> baseInfos, List<MatextarchInfo> selectedInfos) {	
		return MatextMerger.mergeWithMatextarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
