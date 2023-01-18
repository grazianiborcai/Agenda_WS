package br.com.mind5.business.bankAccountSearch.model.action;

import br.com.mind5.business.bankAccountSearch.info.BankaccarchInfo;
import br.com.mind5.business.bankAccountSearch.info.BankaccarchSetterStoreKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BankaccarchVisiEnforceStoreKey extends ActionVisitorTemplateEnforce<BankaccarchInfo> {
	
	public BankaccarchVisiEnforceStoreKey(DeciTreeOption<BankaccarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected BankaccarchInfo enforceHook(BankaccarchInfo recordInfo) {
		InfoSetter<BankaccarchInfo> attrSetter = new BankaccarchSetterStoreKey();
		return attrSetter.setAttr(recordInfo);
	}
}
