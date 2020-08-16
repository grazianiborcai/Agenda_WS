package br.com.mind5.business.materialStoreSnapshot.model.action;

import br.com.mind5.business.materialStoreSnapshot.info.MatorapInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatorapDaoInsert extends ActionStdTemplateV2<MatorapInfo> {

	public StdMatorapDaoInsert(DeciTreeOption<MatorapInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<MatorapInfo> buildVisitorHook(DeciTreeOption<MatorapInfo> option) {
		return new VisiMatorapDaoInsert(option);
	}
}
