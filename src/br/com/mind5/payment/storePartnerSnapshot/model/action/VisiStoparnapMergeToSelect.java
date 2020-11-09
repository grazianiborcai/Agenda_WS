package br.com.mind5.payment.storePartnerSnapshot.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartnerSnapshot.info.StoparnapInfo;
import br.com.mind5.payment.storePartnerSnapshot.info.StoparnapMerger;

final class VisiStoparnapMergeToSelect extends ActionVisitorTemplateMergeV2<StoparnapInfo, StoparnapInfo> {
	
	public VisiStoparnapMergeToSelect(DeciTreeOption<StoparnapInfo> option) {
		super(option, StoparnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<StoparnapInfo>> getActionClassHook() {
		return StdStoparnapDaoSelect.class;
	}
	
	
	
	@Override protected List<StoparnapInfo> mergeHook(List<StoparnapInfo> baseInfos, List<StoparnapInfo> selectedInfos) {	
		return StoparnapMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
