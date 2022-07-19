package br.com.mind5.payment.creditCardSearch.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCardSearch.info.CrecarchInfo;
import br.com.mind5.payment.creditCardSearch.info.CrecarchMerger;

public final class CrecarchVisiMergeToSelect extends ActionVisitorTemplateMerge<CrecarchInfo, CrecarchInfo> {
	
	public CrecarchVisiMergeToSelect(DeciTreeOption<CrecarchInfo> option) {
		super(option, CrecarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<CrecarchInfo>> getVisitorClassHook() {
		return CrecarchVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<CrecarchInfo> mergeHook(List<CrecarchInfo> baseInfos, List<CrecarchInfo> selectedInfos) {	
		return CrecarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
