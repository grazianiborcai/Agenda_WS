package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipMerger;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.info.TokemoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.decisionTree.RootTokemoipGenerate;

public final class PeresmoipVisiTokemoipGenerate extends ActionVisitorTemplateAction<PeresmoipInfo, TokemoipInfo> {
	
	public PeresmoipVisiTokemoipGenerate(DeciTreeOption<PeresmoipInfo> option) {
		super(option, PeresmoipInfo.class, TokemoipInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<TokemoipInfo>> getTreeClassHook() {
		return RootTokemoipGenerate.class;
	}
	
	
	
	@Override protected List<PeresmoipInfo> toBaseClassHook(List<PeresmoipInfo> baseInfos, List<TokemoipInfo> results) {
		return PeresmoipMerger.mergeWithTokemoip(baseInfos, results);
	}
}
