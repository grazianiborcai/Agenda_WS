package br.com.mind5.payment.storePartner.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartner.info.StoparInfo;
import br.com.mind5.payment.storePartner.info.StoparMerger;

public final class StoparVisiMergeToSelect extends ActionVisitorTemplateMerge<StoparInfo, StoparInfo> {
	
	public StoparVisiMergeToSelect(DeciTreeOption<StoparInfo> option) {
		super(option, StoparInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<StoparInfo>> getVisitorClassHook() {
		return StoparVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<StoparInfo> mergeHook(List<StoparInfo> baseInfos, List<StoparInfo> selectedInfos) {	
		return StoparMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
