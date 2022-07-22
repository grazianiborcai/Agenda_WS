package br.com.mind5.payment.storePartnerSnapshot.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartnerSnapshot.info.StoparnapInfo;
import br.com.mind5.payment.storePartnerSnapshot.info.StoparnapMerger;

public final class StoparnapVisiMergeToSelect extends ActionVisitorTemplateMerge<StoparnapInfo, StoparnapInfo> {
	
	public StoparnapVisiMergeToSelect(DeciTreeOption<StoparnapInfo> option) {
		super(option, StoparnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<StoparnapInfo>> getVisitorClassHook() {
		return StoparnapVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<StoparnapInfo> mergeHook(List<StoparnapInfo> baseInfos, List<StoparnapInfo> selectedInfos) {	
		return StoparnapMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
