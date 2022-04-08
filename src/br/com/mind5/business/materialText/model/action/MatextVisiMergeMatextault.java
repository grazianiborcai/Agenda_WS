package br.com.mind5.business.materialText.model.action;

import java.util.List;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialText.info.MatextMerger;
import br.com.mind5.business.materialTextDefault.info.MatextaultInfo;
import br.com.mind5.business.materialTextDefault.model.decisionTree.MatextaultRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatextVisiMergeMatextault extends ActionVisitorTemplateMerge<MatextInfo, MatextaultInfo> {
	
	public MatextVisiMergeMatextault(DeciTreeOption<MatextInfo> option) {
		super(option, MatextaultInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatextaultInfo>> getTreeClassHook() {
		return MatextaultRootSelect.class;
	}
	
	
	
	@Override protected List<MatextInfo> mergeHook(List<MatextInfo> baseInfos, List<MatextaultInfo> selectedInfos) {	
		return MatextMerger.mergeWithMatextault(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
