package br.com.mind5.business.orderItemSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.material.info.MatCopier;
import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.decisionTree.MatRootSelect;
import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.business.orderItemSnapshot.info.OrdemrapMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrdemrapMergeMat extends ActionVisitorTemplateMerge<OrdemrapInfo, MatInfo> {
	
	public VisiOrdemrapMergeMat(DeciTreeOption<OrdemrapInfo> option) {
		super(option, MatInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatInfo>> getTreeClassHook() {
		return MatRootSelect.class;
	}
	
	
	
	@Override protected List<MatInfo> toActionClassHook(List<OrdemrapInfo> baseInfos) {
		return MatCopier.copyFromOrdemrap(baseInfos);	
	}
	
	
	
	@Override protected List<OrdemrapInfo> mergeHook(List<OrdemrapInfo> baseInfos, List<MatInfo> selectedInfos) {	
		return OrdemrapMerger.mergeWithMat(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
