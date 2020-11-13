package br.com.mind5.payment.ownerPartner.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.ownerPartner.info.OwnparInfo;

public final class StdOwnparMergeOwner extends ActionStdTemplate<OwnparInfo> {

	public StdOwnparMergeOwner(DeciTreeOption<OwnparInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<OwnparInfo> buildVisitorHook(DeciTreeOption<OwnparInfo> option) {
		return new VisiOwnparMergeOwner(option);
	}
}
