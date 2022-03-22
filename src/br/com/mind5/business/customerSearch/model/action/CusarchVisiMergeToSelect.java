package br.com.mind5.business.customerSearch.model.action;

import java.util.List;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.business.customerSearch.info.CusarchMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CusarchVisiMergeToSelect extends ActionVisitorTemplateMerge<CusarchInfo, CusarchInfo> {
	
	public CusarchVisiMergeToSelect(DeciTreeOption<CusarchInfo> option) {
		super(option, CusarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<CusarchInfo>> getVisitorClassHook() {
		return CusarchVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<CusarchInfo> mergeHook(List<CusarchInfo> baseInfos, List<CusarchInfo> selectedInfos) {	
		return CusarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
