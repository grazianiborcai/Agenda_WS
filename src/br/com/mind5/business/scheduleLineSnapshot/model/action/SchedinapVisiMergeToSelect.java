package br.com.mind5.business.scheduleLineSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedinapVisiMergeToSelect extends ActionVisitorTemplateMerge<SchedinapInfo, SchedinapInfo> {
	
	public SchedinapVisiMergeToSelect(DeciTreeOption<SchedinapInfo> option) {
		super(option, SchedinapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<SchedinapInfo>> getVisitorClassHook() {
		return SchedinapVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<SchedinapInfo> mergeHook(List<SchedinapInfo> baseInfos, List<SchedinapInfo> selectedInfos) {	
		return SchedinapMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
