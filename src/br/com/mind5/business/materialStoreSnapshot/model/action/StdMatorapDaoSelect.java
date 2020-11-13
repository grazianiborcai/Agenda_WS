package br.com.mind5.business.materialStoreSnapshot.model.action;

import br.com.mind5.business.materialStoreSnapshot.info.MatorapInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatorapDaoSelect extends ActionStdTemplate<MatorapInfo> {

	public StdMatorapDaoSelect(DeciTreeOption<MatorapInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<MatorapInfo> buildVisitorHook(DeciTreeOption<MatorapInfo> option) {
		return new VisiMatorapDaoSelect(option);
	}
}
