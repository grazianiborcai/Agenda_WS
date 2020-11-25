package br.com.mind5.business.orderItemSearch.model.action;

import br.com.mind5.business.orderItemSearch.info.OrdemarchInfo;
import br.com.mind5.business.orderItemSearch.info.OrdemarchSetterOrderKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrdemarchEnforceOrderKey extends ActionVisitorTemplateEnforce<OrdemarchInfo> {
	
	public VisiOrdemarchEnforceOrderKey(DeciTreeOption<OrdemarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected OrdemarchInfo enforceHook(OrdemarchInfo recordInfo) {
		InfoSetter<OrdemarchInfo> setter = new OrdemarchSetterOrderKey();
		return setter.setAttr(recordInfo);
	}
}
