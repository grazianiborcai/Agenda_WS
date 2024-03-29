package br.com.mind5.business.material.model.action;

import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.info.MatMerger;
import br.com.mind5.masterData.materialCategory.info.MategInfo;
import br.com.mind5.masterData.materialCategory.model.decisionTree.MategRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatVisiMergeMateg extends ActionVisitorTemplateMerge<MatInfo, MategInfo> {
	
	public MatVisiMergeMateg(DeciTreeOption<MatInfo> option) {
		super(option, MategInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MategInfo>> getTreeClassHook() {
		return MategRootSelect.class;
	}
	
	
	
	@Override protected List<MatInfo> mergeHook(List<MatInfo> baseInfos, List<MategInfo> selectedInfos) {	
		return MatMerger.mergeWithMateg(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
