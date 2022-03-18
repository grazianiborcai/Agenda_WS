package br.com.mind5.business.material.model.action;

import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.info.MatMerger;
import br.com.mind5.masterData.materialUnit.info.MatunitInfo;
import br.com.mind5.masterData.materialUnit.model.decisionTree.RootMatunitSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatVisiMergeMatunit extends ActionVisitorTemplateMerge<MatInfo, MatunitInfo> {
	
	public MatVisiMergeMatunit(DeciTreeOption<MatInfo> option) {
		super(option, MatunitInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatunitInfo>> getTreeClassHook() {
		return RootMatunitSelect.class;
	}
	
	
	
	@Override protected List<MatInfo> mergeHook(List<MatInfo> baseInfos, List<MatunitInfo> selectedInfos) {	
		return MatMerger.mergeWithMatunit(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
