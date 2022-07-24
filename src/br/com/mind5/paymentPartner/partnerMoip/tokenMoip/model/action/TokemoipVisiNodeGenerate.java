package br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.info.TokemoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.decisionTree.TokemoipNodeGenerate;

public final class TokemoipVisiNodeGenerate extends ActionVisitorTemplateAction<TokemoipInfo, TokemoipInfo> {

	public TokemoipVisiNodeGenerate(DeciTreeOption<TokemoipInfo> option) {
		super(option, TokemoipInfo.class, TokemoipInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<TokemoipInfo>> getTreeClassHook() {
		return TokemoipNodeGenerate.class;
	}
	
	
	
	@Override protected List<TokemoipInfo> toBaseClassHook(List<TokemoipInfo> baseInfos, List<TokemoipInfo> results) {
		return results;
	}
}
