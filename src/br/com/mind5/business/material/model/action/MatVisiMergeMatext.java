package br.com.mind5.business.material.model.action;

import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.info.MatMerger;
import br.com.mind5.business.materialText.info.MatextCopier;
import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialText.model.decisionTree.RootMatextSearch;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatVisiMergeMatext extends ActionVisitorTemplateMerge<MatInfo, MatextInfo> {
	
	public MatVisiMergeMatext(DeciTreeOption<MatInfo> option) {
		super(option, MatextInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatextInfo>> getTreeClassHook() {
		return RootMatextSearch.class;
	}
	
	
	
	@Override protected List<MatextInfo> toActionClassHook(List<MatInfo> baseInfos) {
		return MatextCopier.copyFromMatKey(baseInfos);
	}	
	
	
	
	@Override protected List<MatInfo> mergeHook(List<MatInfo> baseInfos, List<MatextInfo> selectedInfos) {	
		return MatMerger.mergeWithMatext(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
