package br.com.mind5.payment.creditCard.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.info.CrecardMerger;
import br.com.mind5.payment.customerPartner.info.CusparCopier;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.model.decisionTree.RootCusparInsertAuth;

public final class CrecardVisiCusparInsert extends ActionVisitorTemplateAction<CrecardInfo, CusparInfo> {
	
	public CrecardVisiCusparInsert(DeciTreeOption<CrecardInfo> option) {
		super(option, CrecardInfo.class, CusparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CusparInfo>> getTreeClassHook() {
		return RootCusparInsertAuth.class;
	}
	
	
	
	@Override protected List<CusparInfo> toActionClassHook(List<CrecardInfo> baseInfos) {
		return CusparCopier.copyFromCrecard(baseInfos);
	}
	
	
	
	@Override protected List<CrecardInfo> toBaseClassHook(List<CrecardInfo> baseInfos, List<CusparInfo> selectedInfos) {
		return CrecardMerger.mergeWithCusparInsert(baseInfos, selectedInfos);
	}
}
