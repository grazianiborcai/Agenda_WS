package br.com.mind5.business.scheduleLineSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedinapMergeToSelect extends ActionVisitorTemplateMerge<SchedinapInfo, SchedinapInfo> {
	
	public VisiSchedinapMergeToSelect(DeciTreeOption<SchedinapInfo> option) {
		super(option, SchedinapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<SchedinapInfo>> getActionClassHook() {
		return StdSchedinapDaoSelect.class;
	}
	
	
	
	@Override protected List<SchedinapInfo> mergeHook(List<SchedinapInfo> baseInfos, List<SchedinapInfo> selectedInfos) {	
		return SchedinapMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
