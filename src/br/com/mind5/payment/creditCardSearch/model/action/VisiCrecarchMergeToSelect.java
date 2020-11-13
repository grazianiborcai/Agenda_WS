package br.com.mind5.payment.creditCardSearch.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCardSearch.info.CrecarchInfo;
import br.com.mind5.payment.creditCardSearch.info.CrecarchMerger;

final class VisiCrecarchMergeToSelect extends ActionVisitorTemplateMerge<CrecarchInfo, CrecarchInfo> {
	
	public VisiCrecarchMergeToSelect(DeciTreeOption<CrecarchInfo> option) {
		super(option, CrecarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<CrecarchInfo>> getActionClassHook() {
		return StdCrecarchDaoSelect.class;
	}
	
	
	
	@Override protected List<CrecarchInfo> mergeHook(List<CrecarchInfo> baseInfos, List<CrecarchInfo> selectedInfos) {	
		return CrecarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
