package br.com.mind5.payment.ownerPartner.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.ownerPartner.info.OwnparInfo;
import br.com.mind5.payment.ownerPartner.info.OwnparMerger;

public final class OwnparVisiMergeToSelect extends ActionVisitorTemplateMerge<OwnparInfo, OwnparInfo> {
	
	public OwnparVisiMergeToSelect(DeciTreeOption<OwnparInfo> option) {
		super(option, OwnparInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<OwnparInfo>> getVisitorClassHook() {
		return OwnparVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<OwnparInfo> mergeHook(List<OwnparInfo> baseInfos, List<OwnparInfo> selectedInfos) {	
		return OwnparMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
