package br.com.mind5.business.phoneSnapshotSearch.model.action;

import java.util.List;

import br.com.mind5.business.phoneSnapshotSearch.info.PhonaparchInfo;
import br.com.mind5.business.phoneSnapshotSearch.info.PhonaparchMerger;
import br.com.mind5.model.action.ActionStd;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPhonaparchMergeToSelect extends ActionVisitorTemplateMerge<PhonaparchInfo, PhonaparchInfo> {
	
	public VisiPhonaparchMergeToSelect(DeciTreeOption<PhonaparchInfo> option) {
		super(option, PhonaparchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<PhonaparchInfo>> getActionClassHook() {
		return StdPhonaparchDaoSelect.class;
	}
	
	
	
	@Override protected List<PhonaparchInfo> mergeHook(List<PhonaparchInfo> baseInfos, List<PhonaparchInfo> selectedInfos) {	
		return PhonaparchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
