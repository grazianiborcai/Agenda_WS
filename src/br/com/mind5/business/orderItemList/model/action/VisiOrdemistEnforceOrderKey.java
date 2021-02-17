package br.com.mind5.business.orderItemList.model.action;

import br.com.mind5.business.orderItemList.info.OrdemistInfo;
import br.com.mind5.business.orderItemList.info.OrdemistSetterOrderKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrdemistEnforceOrderKey extends ActionVisitorTemplateEnforce<OrdemistInfo> {
	
	public VisiOrdemistEnforceOrderKey(DeciTreeOption<OrdemistInfo> option) {
		super(option);
	}
	
	
	
	@Override protected OrdemistInfo enforceHook(OrdemistInfo recordInfo) {
		InfoSetter<OrdemistInfo> setter = new OrdemistSetterOrderKey();
		return setter.setAttr(recordInfo);
	}
}
