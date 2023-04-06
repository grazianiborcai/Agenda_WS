package br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.model.decisionTree.CrecardRootSelect;
import br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.info.OrdapaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.info.OrdapaMerger;

public final class OrdapaVisiMergeCrecard extends ActionVisitorTemplateMerge<OrdapaInfo, CrecardInfo> {
	
	public OrdapaVisiMergeCrecard(DeciTreeOption<OrdapaInfo> option) {
		super(option, CrecardInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<CrecardInfo>> getTreeClassHook() {
		return CrecardRootSelect.class;
	}
	
	
	
	@Override protected List<OrdapaInfo> mergeHook(List<OrdapaInfo> baseInfos, List<CrecardInfo> selectedInfos) {	
		return OrdapaMerger.mergeWithCrecard(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
