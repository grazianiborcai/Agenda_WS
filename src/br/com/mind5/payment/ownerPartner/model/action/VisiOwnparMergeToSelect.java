package br.com.mind5.payment.ownerPartner.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.ownerPartner.info.OwnparInfo;
import br.com.mind5.payment.ownerPartner.info.OwnparMerger;

final class VisiOwnparMergeToSelect extends ActionVisitorTemplateMerge<OwnparInfo, OwnparInfo> {
	
	public VisiOwnparMergeToSelect(DeciTreeOption<OwnparInfo> option) {
		super(option, OwnparInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<OwnparInfo>> getActionClassHook() {
		return StdOwnparDaoSelect.class;
	}
	
	
	
	@Override protected List<OwnparInfo> mergeHook(List<OwnparInfo> baseInfos, List<OwnparInfo> selectedInfos) {	
		return OwnparMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
