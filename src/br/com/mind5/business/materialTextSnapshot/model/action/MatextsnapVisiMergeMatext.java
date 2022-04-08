package br.com.mind5.business.materialTextSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.materialText.info.MatextCopier;
import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialText.model.decisionTree.MatextRootSearch;
import br.com.mind5.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.mind5.business.materialTextSnapshot.info.MatextsnapMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatextsnapVisiMergeMatext extends ActionVisitorTemplateMerge<MatextsnapInfo, MatextInfo> {
	
	public MatextsnapVisiMergeMatext(DeciTreeOption<MatextsnapInfo> option) {
		super(option, MatextInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatextInfo>> getTreeClassHook() {
		return MatextRootSearch.class;
	}
	
	
	
	@Override protected List<MatextInfo> toActionClassHook(List<MatextsnapInfo> baseInfos) {
		return MatextCopier.copyFromMatextsnap(baseInfos);	
	}	
	
	
	
	@Override protected List<MatextsnapInfo> mergeHook(List<MatextsnapInfo> baseInfos, List<MatextInfo> selectedInfos) {	
		return MatextsnapMerger.mergeWithMatext(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
