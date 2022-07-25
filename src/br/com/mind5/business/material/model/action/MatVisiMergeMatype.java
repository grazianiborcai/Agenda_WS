package br.com.mind5.business.material.model.action;

import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.info.MatMerger;
import br.com.mind5.masterData.materialType.info.MatypeInfo;
import br.com.mind5.masterData.materialType.model.decisionTree.MatypeRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatVisiMergeMatype extends ActionVisitorTemplateMerge<MatInfo, MatypeInfo> {
	
	public MatVisiMergeMatype(DeciTreeOption<MatInfo> option) {
		super(option, MatypeInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatypeInfo>> getTreeClassHook() {
		return MatypeRootSelect.class;
	}
	
	
	
	@Override protected List<MatInfo> mergeHook(List<MatInfo> baseInfos, List<MatypeInfo> selectedInfos) {	
		return MatMerger.mergeWithMatype(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
