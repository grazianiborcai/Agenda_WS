package br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.marketplacePartner.info.MktparInfo;
import br.com.mind5.payment.marketplacePartner.model.decisionTree.MktparRootSelect;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.info.TokemoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.info.TokemoipMerger;

public final class TokemoipVisiMergeSyspar extends ActionVisitorTemplateMerge<TokemoipInfo, MktparInfo> {
	
	public TokemoipVisiMergeSyspar(DeciTreeOption<TokemoipInfo> option) {
		super(option, MktparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MktparInfo>> getTreeClassHook() {
		return MktparRootSelect.class;
	}
	
	
	
	@Override protected List<TokemoipInfo> mergeHook(List<TokemoipInfo> baseInfos, List<MktparInfo> selectedInfos) {	
		return TokemoipMerger.mergeWithSyspar(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
