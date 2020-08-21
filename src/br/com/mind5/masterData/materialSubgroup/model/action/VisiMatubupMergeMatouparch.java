package br.com.mind5.masterData.materialSubgroup.model.action;

import java.util.List;

import br.com.mind5.masterData.materialSubgroup.info.MatubupInfo;
import br.com.mind5.masterData.materialSubgroup.info.MatubupMerger;
import br.com.mind5.masterData.materialGroupSearch.info.MatouparchInfo;
import br.com.mind5.masterData.materialGroupSearch.model.decisionTree.RootMatouparchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatubupMergeMatouparch extends ActionVisitorTemplateMergeV2<MatubupInfo, MatouparchInfo> {
	
	public VisiMatubupMergeMatouparch(DeciTreeOption<MatubupInfo> option) {
		super(option, MatouparchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatouparchInfo>> getTreeClassHook() {
		return RootMatouparchSelect.class;
	}
	
	
	
	@Override protected List<MatubupInfo> mergeHook(List<MatubupInfo> baseInfos, List<MatouparchInfo> selectedInfos) {
		return MatubupMerger.mergeWithMatouparch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
