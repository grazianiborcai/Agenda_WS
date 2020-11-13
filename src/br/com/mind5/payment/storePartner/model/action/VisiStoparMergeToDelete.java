package br.com.mind5.payment.storePartner.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartner.info.StoparInfo;
import br.com.mind5.payment.storePartner.info.StoparMerger;

final class VisiStoparMergeToDelete extends ActionVisitorTemplateMerge<StoparInfo, StoparInfo> {
	
	public VisiStoparMergeToDelete(DeciTreeOption<StoparInfo> option) {
		super(option, StoparInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<StoparInfo>> getActionClassHook() {
		return StdStoparDaoSelect.class;
	}
	
	
	
	@Override protected List<StoparInfo> mergeHook(List<StoparInfo> baseInfos, List<StoparInfo> selectedInfos) {	
		return StoparMerger.mergeToDelete(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}	
}
