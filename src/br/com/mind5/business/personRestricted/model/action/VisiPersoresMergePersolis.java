package br.com.mind5.business.personRestricted.model.action;

import java.util.List;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.business.personList.model.decisionTree.PersolisRootSelect;
import br.com.mind5.business.personRestricted.info.PersoresInfo;
import br.com.mind5.business.personRestricted.info.PersoresMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPersoresMergePersolis extends ActionVisitorTemplateMerge<PersoresInfo, PersolisInfo> {
	
	public VisiPersoresMergePersolis(DeciTreeOption<PersoresInfo> option) {
		super(option, PersolisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersolisInfo>> getTreeClassHook() {
		return PersolisRootSelect.class;
	}
	
	
	
	@Override protected List<PersoresInfo> mergeHook(List<PersoresInfo> recordInfos, List<PersolisInfo> selectedInfos) {	
		return PersoresMerger.mergeWithPersolis(recordInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
