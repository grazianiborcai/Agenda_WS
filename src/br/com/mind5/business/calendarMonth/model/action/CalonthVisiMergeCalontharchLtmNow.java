package br.com.mind5.business.calendarMonth.model.action;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.business.calendarMonth.info.CalonthMerger;
import br.com.mind5.business.calendarMonthSearch.info.CalontharchInfo;
import br.com.mind5.business.calendarMonthSearch.model.decisionTree.CalontharchRootSelectLtmNow;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CalonthVisiMergeCalontharchLtmNow extends ActionVisitorTemplateMerge<CalonthInfo, CalontharchInfo> {
	
	public CalonthVisiMergeCalontharchLtmNow(DeciTreeOption<CalonthInfo> option) {
		super(option, CalontharchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CalontharchInfo>> getTreeClassHook() {
		return CalontharchRootSelectLtmNow.class;
	}
	
	
	
	@Override protected List<CalonthInfo> mergeHook(List<CalonthInfo> baseInfos, List<CalontharchInfo> selectedInfos) {	
		return CalonthMerger.mergeWithCalontharch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
