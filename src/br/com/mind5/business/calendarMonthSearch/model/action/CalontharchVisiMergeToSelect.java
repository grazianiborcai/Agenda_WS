package br.com.mind5.business.calendarMonthSearch.model.action;

import java.util.List;

import br.com.mind5.business.calendarMonthSearch.info.CalontharchInfo;
import br.com.mind5.business.calendarMonthSearch.info.CalontharchMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CalontharchVisiMergeToSelect extends ActionVisitorTemplateMerge<CalontharchInfo, CalontharchInfo> {
	
	public CalontharchVisiMergeToSelect(DeciTreeOption<CalontharchInfo> option) {
		super(option, CalontharchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<CalontharchInfo>> getVisitorClassHook() {
		return CalontharchVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<CalontharchInfo> mergeHook(List<CalontharchInfo> baseInfos, List<CalontharchInfo> selectedInfos) {	
		return CalontharchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
