package br.com.mind5.business.calendarMonth.model.action;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.business.calendarMonth.info.CalonthMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CalonthVisiMergeToSelect extends ActionVisitorTemplateMerge<CalonthInfo, CalonthInfo> {
	
	public CalonthVisiMergeToSelect(DeciTreeOption<CalonthInfo> option) {
		super(option, CalonthInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<CalonthInfo>> getVisitorClassHook() {
		return CalonthVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<CalonthInfo> mergeHook(List<CalonthInfo> baseInfos, List<CalonthInfo> selectedInfos) {	
		return CalonthMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
