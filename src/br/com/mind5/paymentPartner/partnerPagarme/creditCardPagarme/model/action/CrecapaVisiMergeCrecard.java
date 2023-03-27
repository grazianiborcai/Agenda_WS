package br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.model.decisionTree.CrecardRootSelect;
import br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.info.CrecapaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.info.CrecapaMerger;

public final class CrecapaVisiMergeCrecard extends ActionVisitorTemplateMerge<CrecapaInfo, CrecardInfo> {
	
	public CrecapaVisiMergeCrecard(DeciTreeOption<CrecapaInfo> option) {
		super(option, CrecardInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<CrecardInfo>> getTreeClassHook() {
		return CrecardRootSelect.class;
	}
	
	
	
	@Override protected List<CrecapaInfo> mergeHook(List<CrecapaInfo> baseInfos, List<CrecardInfo> selectedInfos) {	
		return CrecapaMerger.mergeWithCrecard(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
