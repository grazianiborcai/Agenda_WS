package br.com.mind5.business.materialStoreSearch.model.action;

import br.com.mind5.business.materialStoreSearch.info.MatorarchInfo;
import br.com.mind5.business.materialStoreSearch.info.MatorarchSetterStoreKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatorarchVisiEnforceStoreKey extends ActionVisitorTemplateEnforce<MatorarchInfo> {
	
	public MatorarchVisiEnforceStoreKey(DeciTreeOption<MatorarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected MatorarchInfo enforceHook(MatorarchInfo recordInfo) {
		InfoSetter<MatorarchInfo> attrSetter = new MatorarchSetterStoreKey();
		return attrSetter.setAttr(recordInfo);
	}
}
