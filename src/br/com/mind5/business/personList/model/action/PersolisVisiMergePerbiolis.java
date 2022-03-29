package br.com.mind5.business.personList.model.action;

import java.util.List;

import br.com.mind5.business.personBioList.info.PerbiolisInfo;
import br.com.mind5.business.personBioList.model.decisionTree.PerbiolisRootSelectFallback;
import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.business.personList.info.PersolisMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PersolisVisiMergePerbiolis extends ActionVisitorTemplateMerge<PersolisInfo, PerbiolisInfo> {
	
	public PersolisVisiMergePerbiolis(DeciTreeOption<PersolisInfo> option) {
		super(option, PerbiolisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PerbiolisInfo>> getTreeClassHook() {
		return PerbiolisRootSelectFallback.class;
	}
	
	
	
	@Override protected List<PersolisInfo> mergeHook(List<PersolisInfo> recordInfos, List<PerbiolisInfo> selectedInfos) {	
		return PersolisMerger.mergeWithPerbiolis(recordInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
