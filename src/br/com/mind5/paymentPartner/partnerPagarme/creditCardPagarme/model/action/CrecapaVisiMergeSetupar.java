package br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.payment.setupPartner.model.decisionTree.SetuparRootSelect;
import br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.info.CrecapaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.info.CrecapaMerger;

public final class CrecapaVisiMergeSetupar extends ActionVisitorTemplateMerge<CrecapaInfo, SetuparInfo> {
	
	public CrecapaVisiMergeSetupar(DeciTreeOption<CrecapaInfo> option) {
		super(option, SetuparInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<SetuparInfo>> getTreeClassHook() {
		return SetuparRootSelect.class;
	}
	
	
	
	@Override protected List<CrecapaInfo> mergeHook(List<CrecapaInfo> baseInfos, List<SetuparInfo> selectedInfos) {	
		return CrecapaMerger.mergeWithSetupar(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
