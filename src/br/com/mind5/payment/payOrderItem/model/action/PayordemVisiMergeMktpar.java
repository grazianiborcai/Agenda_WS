package br.com.mind5.payment.payOrderItem.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.marketplacePartner.info.MktparInfo;
import br.com.mind5.payment.marketplacePartner.model.decisionTree.MktparRootSelect;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderItem.info.PayordemMerger;

public final class PayordemVisiMergeMktpar extends ActionVisitorTemplateMerge<PayordemInfo, MktparInfo> {
	
	public PayordemVisiMergeMktpar(DeciTreeOption<PayordemInfo> option) {
		super(option, MktparInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<MktparInfo>> getTreeClassHook() {
		return MktparRootSelect.class;
	}
	
	
	
	@Override protected List<PayordemInfo> mergeHook(List<PayordemInfo> baseInfos, List<MktparInfo> selectedInfos) {	
		return PayordemMerger.mergeWithMktpar(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
