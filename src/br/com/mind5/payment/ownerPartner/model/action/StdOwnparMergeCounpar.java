package br.com.mind5.payment.ownerPartner.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.ownerPartner.info.OwnparInfo;

public final class StdOwnparMergeCounpar extends ActionStdTemplate<OwnparInfo> {

	public StdOwnparMergeCounpar(DeciTreeOption<OwnparInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<OwnparInfo> buildVisitorHook(DeciTreeOption<OwnparInfo> option) {
		return new VisiOwnparMergeCounpar(option);
	}
}
