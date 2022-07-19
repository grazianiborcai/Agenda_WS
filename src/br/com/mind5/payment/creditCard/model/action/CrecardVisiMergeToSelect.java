package br.com.mind5.payment.creditCard.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.info.CrecardMerger;

public final class CrecardVisiMergeToSelect extends ActionVisitorTemplateMerge<CrecardInfo, CrecardInfo> {
	
	public CrecardVisiMergeToSelect(DeciTreeOption<CrecardInfo> option) {
		super(option, CrecardInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<CrecardInfo>> getVisitorClassHook() {
		return CrecardVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<CrecardInfo> mergeHook(List<CrecardInfo> baseInfos, List<CrecardInfo> selectedInfos) {	
		return CrecardMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
