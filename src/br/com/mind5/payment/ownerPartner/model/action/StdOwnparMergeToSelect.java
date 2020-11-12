package br.com.mind5.payment.ownerPartner.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.ownerPartner.info.OwnparInfo;

public final class StdOwnparMergeToSelect extends ActionStdTemplateV2<OwnparInfo> {

	public StdOwnparMergeToSelect(DeciTreeOption<OwnparInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<OwnparInfo> buildVisitorHook(DeciTreeOption<OwnparInfo> option) {
		return new VisiOwnparMergeToSelect(option);
	}
}
