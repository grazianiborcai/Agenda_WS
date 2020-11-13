package br.com.mind5.payment.creditCard.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.info.CrecardMerger;

final class VisiCrecardMergeToSelect extends ActionVisitorTemplateMerge<CrecardInfo, CrecardInfo> {
	
	public VisiCrecardMergeToSelect(DeciTreeOption<CrecardInfo> option) {
		super(option, CrecardInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<CrecardInfo>> getActionClassHook() {
		return StdCrecardDaoSelect.class;
	}
	
	
	
	@Override protected List<CrecardInfo> mergeHook(List<CrecardInfo> baseInfos, List<CrecardInfo> selectedInfos) {	
		return CrecardMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
