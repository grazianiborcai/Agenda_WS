package br.com.mind5.business.scheduleLineSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedinapMergeToSelect extends ActionVisitorTemplateMergeV2<SchedinapInfo, SchedinapInfo> {
	
	public VisiSchedinapMergeToSelect(DeciTreeOption<SchedinapInfo> option) {
		super(option, SchedinapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<SchedinapInfo>> getActionClassHook() {
		return StdSchedinapDaoSelect.class;
	}
	
	
	
	@Override protected List<SchedinapInfo> mergeHook(List<SchedinapInfo> baseInfos, List<SchedinapInfo> selectedInfos) {	
		return SchedinapMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
