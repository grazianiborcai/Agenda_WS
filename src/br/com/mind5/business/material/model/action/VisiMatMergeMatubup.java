package br.com.mind5.business.material.model.action;

import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.info.MatMerger;
import br.com.mind5.masterData.materialSubgroup.info.MatubupInfo;
import br.com.mind5.masterData.materialSubgroup.model.decisionTree.RootMatubupSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatMergeMatubup extends ActionVisitorTemplateMergeV2<MatInfo, MatubupInfo> {
	
	public VisiMatMergeMatubup(DeciTreeOption<MatInfo> option) {
		super(option, MatubupInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatubupInfo>> getTreeClassHook() {
		return RootMatubupSelect.class;
	}
	
	
	
	@Override protected List<MatInfo> mergeHook(List<MatInfo> baseInfos, List<MatubupInfo> selectedInfos) {	
		return MatMerger.mergeWithMatubup(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
