package br.com.mind5.masterData.materialGroupOwner.model.action;

import java.util.List;

import br.com.mind5.masterData.materialGroup.info.MatoupInfo;
import br.com.mind5.masterData.materialGroup.model.decisionTree.MatoupRootSearchBusiness;
import br.com.mind5.masterData.materialGroupOwner.info.MatoupowInfo;
import br.com.mind5.masterData.materialGroupOwner.info.MatoupowMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatoupowVisiMergeMatoupSearch extends ActionVisitorTemplateMerge<MatoupowInfo, MatoupInfo> {
	
	public MatoupowVisiMergeMatoupSearch(DeciTreeOption<MatoupowInfo> option) {
		super(option, MatoupInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatoupInfo>> getTreeClassHook() {
		return MatoupRootSearchBusiness.class;
	}
	
	
	
	@Override protected List<MatoupowInfo> mergeHook(List<MatoupowInfo> baseInfos, List<MatoupInfo> selectedInfos) {
		return MatoupowMerger.mergeWithMatoupSearch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
