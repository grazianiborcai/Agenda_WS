package br.com.mind5.business.scheduleReserve.model.action;

import java.util.List;

import br.com.mind5.business.scheduleReserve.info.SchederveInfo;
import br.com.mind5.business.scheduleReserve.info.SchederveMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchederveVisiMergeToSelect extends ActionVisitorTemplateMerge<SchederveInfo, SchederveInfo> {
	
	public SchederveVisiMergeToSelect(DeciTreeOption<SchederveInfo> option) {
		super(option, SchederveInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<SchederveInfo>> getVisitorClassHook() {
		return SchederveVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<SchederveInfo> mergeHook(List<SchederveInfo> baseInfos, List<SchederveInfo> selectedInfos) {	
		return SchederveMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
