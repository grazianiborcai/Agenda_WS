package br.com.mind5.business.materialList.model.action;

import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialList.info.MatlisMerger;
import br.com.mind5.masterData.materialSubgroup.info.MatubupInfo;
import br.com.mind5.masterData.materialSubgroup.model.decisionTree.MatubupRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatlisVisiMergeMatubup extends ActionVisitorTemplateMerge<MatlisInfo, MatubupInfo> {
	
	public MatlisVisiMergeMatubup(DeciTreeOption<MatlisInfo> option) {
		super(option, MatubupInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatubupInfo>> getTreeClassHook() {
		return MatubupRootSelect.class;
	}
	
	
	
	@Override protected List<MatlisInfo> mergeHook(List<MatlisInfo> baseInfos, List<MatubupInfo> selectedInfos) {
		return MatlisMerger.mergeWithMatubup(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
