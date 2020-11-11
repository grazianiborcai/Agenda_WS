package br.com.mind5.payment.storePartner.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartner.info.StoparInfo;
import br.com.mind5.payment.storePartner.info.StoparMerger;

final class VisiStoparMergeToSelect extends ActionVisitorTemplateMergeV2<StoparInfo, StoparInfo> {
	
	public VisiStoparMergeToSelect(DeciTreeOption<StoparInfo> option) {
		super(option, StoparInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<StoparInfo>> getActionClassHook() {
		return StdStoparDaoSelect.class;
	}
	
	
	
	@Override protected List<StoparInfo> mergeHook(List<StoparInfo> baseInfos, List<StoparInfo> selectedInfos) {	
		return StoparMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
