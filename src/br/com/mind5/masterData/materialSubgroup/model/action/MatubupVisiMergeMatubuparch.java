package br.com.mind5.masterData.materialSubgroup.model.action;

import java.util.List;

import br.com.mind5.masterData.materialSubgroup.info.MatubupInfo;
import br.com.mind5.masterData.materialSubgroup.info.MatubupMerger;
import br.com.mind5.masterData.materialSubgroupSearch.info.MatubuparchInfo;
import br.com.mind5.masterData.materialSubgroupSearch.model.decisionTree.RootMatubuparchSelect;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatubupVisiMergeMatubuparch extends ActionVisitorTemplateMerge<MatubupInfo, MatubuparchInfo> {
	
	public MatubupVisiMergeMatubuparch(DeciTreeOption<MatubupInfo> option) {
		super(option, MatubuparchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatubuparchInfo>> getTreeClassHook() {
		return RootMatubuparchSelect.class;
	}
	
	
	
	@Override protected List<MatubupInfo> mergeHook(List<MatubupInfo> baseInfos, List<MatubuparchInfo> selectedInfos) {
		return MatubupMerger.mergeWithMatubuparch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
