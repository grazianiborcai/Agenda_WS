package br.com.mind5.config.payPartnerConfig.model.action;

import java.util.List;

import br.com.mind5.config.payPartnerConfig.info.PayrconfInfo;
import br.com.mind5.config.payPartnerConfig.info.PayrconfMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PayrconfVisiMergeToSelect extends ActionVisitorTemplateMerge<PayrconfInfo, PayrconfInfo> {
	
	public PayrconfVisiMergeToSelect(DeciTreeOption<PayrconfInfo> option) {
		super(option, PayrconfInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<PayrconfInfo>> getVisitorClassHook() {
		return PayrconfVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<PayrconfInfo> mergeHook(List<PayrconfInfo> baseInfos, List<PayrconfInfo> selectedInfos) {	
		return PayrconfMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
