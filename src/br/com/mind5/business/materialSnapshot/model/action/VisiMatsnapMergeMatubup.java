package br.com.mind5.business.materialSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.business.materialSnapshot.info.MatsnapMerger;
import br.com.mind5.masterData.materialSubgroup.info.MatubupInfo;
import br.com.mind5.masterData.materialSubgroup.model.decisionTree.RootMatubupSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatsnapMergeMatubup extends ActionVisitorTemplateMerge<MatsnapInfo, MatubupInfo> {
	
	public VisiMatsnapMergeMatubup(DeciTreeOption<MatsnapInfo> option) {
		super(option, MatubupInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatubupInfo>> getTreeClassHook() {
		return RootMatubupSelect.class;
	}
	
	
	
	@Override protected List<MatsnapInfo> mergeHook(List<MatsnapInfo> baseInfos, List<MatubupInfo> selectedInfos) {	
		return MatsnapMerger.mergeWithMatubup(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
