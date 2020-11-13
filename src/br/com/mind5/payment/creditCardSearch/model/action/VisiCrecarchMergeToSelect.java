package br.com.mind5.payment.creditCardSearch.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCardSearch.info.CrecarchInfo;
import br.com.mind5.payment.creditCardSearch.info.CrecarchMerger;

final class VisiCrecarchMergeToSelect extends ActionVisitorTemplateMergeV2<CrecarchInfo, CrecarchInfo> {
	
	public VisiCrecarchMergeToSelect(DeciTreeOption<CrecarchInfo> option) {
		super(option, CrecarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<CrecarchInfo>> getActionClassHook() {
		return StdCrecarchDaoSelect.class;
	}
	
	
	
	@Override protected List<CrecarchInfo> mergeHook(List<CrecarchInfo> baseInfos, List<CrecarchInfo> selectedInfos) {	
		return CrecarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
