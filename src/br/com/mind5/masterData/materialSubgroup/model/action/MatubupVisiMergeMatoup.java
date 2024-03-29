package br.com.mind5.masterData.materialSubgroup.model.action;

import java.util.List;

import br.com.mind5.masterData.materialGroup.info.MatoupInfo;
import br.com.mind5.masterData.materialGroup.model.decisionTree.MatoupRootSelect;
import br.com.mind5.masterData.materialSubgroup.info.MatubupInfo;
import br.com.mind5.masterData.materialSubgroup.info.MatubupMerger;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatubupVisiMergeMatoup extends ActionVisitorTemplateMerge<MatubupInfo, MatoupInfo> {
	
	public MatubupVisiMergeMatoup(DeciTreeOption<MatubupInfo> option) {
		super(option, MatoupInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatoupInfo>> getTreeClassHook() {
		return MatoupRootSelect.class;
	}
	
	
	
	@Override protected List<MatubupInfo> mergeHook(List<MatubupInfo> baseInfos, List<MatoupInfo> selectedInfos) {
		return MatubupMerger.mergeWithMatoup(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
