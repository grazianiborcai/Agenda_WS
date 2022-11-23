package br.com.mind5.masterData.materialGroup.model.action;

import java.util.List;

import br.com.mind5.masterData.materialGroup.info.MatoupInfo;
import br.com.mind5.masterData.materialGroup.info.MatoupMerger;
import br.com.mind5.masterData.materialGroupSearch.info.MatouparchInfo;
import br.com.mind5.masterData.materialGroupSearch.model.decisionTree.MatouparchRootSelectBusiness;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatoupVisiMergeMatouparchBusiness extends ActionVisitorTemplateMerge<MatoupInfo, MatouparchInfo> {
	
	public MatoupVisiMergeMatouparchBusiness(DeciTreeOption<MatoupInfo> option) {
		super(option, MatouparchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatouparchInfo>> getTreeClassHook() {
		return MatouparchRootSelectBusiness.class;
	}
	
	
	
	@Override protected List<MatoupInfo> mergeHook(List<MatoupInfo> baseInfos, List<MatouparchInfo> selectedInfos) {
		return MatoupMerger.mergeWithMatouparch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
