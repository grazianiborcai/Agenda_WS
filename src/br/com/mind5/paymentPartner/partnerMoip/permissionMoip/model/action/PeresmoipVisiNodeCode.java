package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.decisionTree.PeresmoipNodeCode;

public final class PeresmoipVisiNodeCode extends ActionVisitorTemplateAction<PeresmoipInfo, PeresmoipInfo> {

	public PeresmoipVisiNodeCode(DeciTreeOption<PeresmoipInfo> option) {
		super(option, PeresmoipInfo.class, PeresmoipInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PeresmoipInfo>> getTreeClassHook() {
		return PeresmoipNodeCode.class;
	}
	
	
	
	@Override protected List<PeresmoipInfo> toBaseClassHook(List<PeresmoipInfo> baseInfos, List<PeresmoipInfo> results) {
		return results;
	}
}
