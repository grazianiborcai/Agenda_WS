package br.com.mind5.authorization.storePartitionAuthorization.model.action;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhSetterStore;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSytotauhEnforceStore extends ActionVisitorTemplateEnforce<SytotauhInfo> {
	
	public VisiSytotauhEnforceStore(DeciTreeOption<SytotauhInfo> option) {
		super(option);	
	}
	
	
	
	@Override protected SytotauhInfo enforceHook(SytotauhInfo recordInfo) {
		InfoSetter<SytotauhInfo> attrSetter = new SytotauhSetterStore();
		return attrSetter.setAttr(recordInfo);
	}
}
