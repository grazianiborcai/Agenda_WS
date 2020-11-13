package br.com.mind5.business.orderStatusChange.model.action;

import br.com.mind5.business.orderStatusChange.info.OrdugeInfo;
import br.com.mind5.business.orderStatusChange.info.OrdugeSetterPlaced;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrdugeEnforcePlaced extends ActionVisitorTemplateEnforce<OrdugeInfo> {
	
	public VisiOrdugeEnforcePlaced(DeciTreeOption<OrdugeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected OrdugeInfo enforceHook(OrdugeInfo recordInfo) {
		InfoSetter<OrdugeInfo> setter = new OrdugeSetterPlaced();
		return setter.setAttr(recordInfo);
	}
}
