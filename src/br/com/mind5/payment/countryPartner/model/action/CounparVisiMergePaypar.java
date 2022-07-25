package br.com.mind5.payment.countryPartner.model.action;

import java.util.List;

import br.com.mind5.masterData.paymentPartner.info.PayparInfo;
import br.com.mind5.masterData.paymentPartner.model.decisionTree.PayparRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.countryPartner.info.CounparInfo;
import br.com.mind5.payment.countryPartner.info.CounparMerger;

public final class CounparVisiMergePaypar extends ActionVisitorTemplateMerge<CounparInfo, PayparInfo> {
	
	public CounparVisiMergePaypar(DeciTreeOption<CounparInfo> option) {
		super(option, PayparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayparInfo>> getTreeClassHook() {
		return PayparRootSelect.class;
	}
	
	
	
	@Override protected List<CounparInfo> mergeHook(List<CounparInfo> baseInfos, List<PayparInfo> selectedInfos) {
		return CounparMerger.mergeWithPaypar(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
