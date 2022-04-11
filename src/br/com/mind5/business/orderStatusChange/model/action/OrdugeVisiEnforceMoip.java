package br.com.mind5.business.orderStatusChange.model.action;

import br.com.mind5.business.orderStatusChange.info.OrdugeInfo;
import br.com.mind5.business.orderStatusChange.info.OrdugeSetterMoip;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrdugeVisiEnforceMoip extends ActionVisitorTemplateEnforce<OrdugeInfo> {
	
	public OrdugeVisiEnforceMoip(DeciTreeOption<OrdugeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected OrdugeInfo enforceHook(OrdugeInfo recordInfo) {
		InfoSetter<OrdugeInfo> setter = new OrdugeSetterMoip();
		return setter.setAttr(recordInfo);
	}
}
