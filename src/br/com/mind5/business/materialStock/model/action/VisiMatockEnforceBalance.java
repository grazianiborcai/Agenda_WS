package br.com.mind5.business.materialStock.model.action;

import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.business.materialStock.info.MatockSetterBalance;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatockEnforceBalance extends ActionVisitorTemplateEnforceV2<MatockInfo> {
	
	public VisiMatockEnforceBalance(DeciTreeOption<MatockInfo> option) {
		super(option);
	}
	
	
	
	@Override protected MatockInfo enforceHook(MatockInfo recordInfo) {
		InfoSetter<MatockInfo> attrSetter = new MatockSetterBalance();
		return attrSetter.setAttr(recordInfo);
	}
}
