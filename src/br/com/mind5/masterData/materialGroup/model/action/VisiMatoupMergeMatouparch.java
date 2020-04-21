package br.com.mind5.masterData.materialGroup.model.action;

import java.util.List;

import br.com.mind5.masterData.materialGroup.info.MatoupInfo;
import br.com.mind5.masterData.materialGroup.info.MatoupMerger;
import br.com.mind5.masterData.materialGroupSearch.info.MatouparchInfo;
import br.com.mind5.masterData.materialGroupSearch.model.decisionTree.RootMatouparchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatoupMergeMatouparch extends ActionVisitorTemplateMergeV2<MatoupInfo, MatouparchInfo> {
	
	public VisiMatoupMergeMatouparch(DeciTreeOption<MatoupInfo> option) {
		super(option, MatouparchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatouparchInfo>> getTreeClassHook() {
		return RootMatouparchSelect.class;
	}
	
	
	
	@Override protected List<MatoupInfo> mergeHook(List<MatoupInfo> baseInfos, List<MatouparchInfo> selectedInfos) {
		return MatoupMerger.mergeWithMatouparch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
