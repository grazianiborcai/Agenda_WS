package br.com.mind5.business.materialPrice.model.action;

import java.util.List;

import br.com.mind5.business.materialPrice.info.MaticeInfo;
import br.com.mind5.business.materialPrice.info.MaticeMerger;
import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.decisionTree.MatoreRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MaticeVisiMergeMatore extends ActionVisitorTemplateMerge<MaticeInfo, MatoreInfo> {
	
	public MaticeVisiMergeMatore(DeciTreeOption<MaticeInfo> option) {
		super(option, MatoreInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatoreInfo>> getTreeClassHook() {
		return MatoreRootSelect.class;
	}
	
	
	
	@Override protected List<MaticeInfo> mergeHook(List<MaticeInfo> baseInfos, List<MatoreInfo> selectedInfos) {	
		return MaticeMerger.mergeWithMatore(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
