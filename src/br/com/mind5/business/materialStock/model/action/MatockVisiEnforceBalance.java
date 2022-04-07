package br.com.mind5.business.materialStock.model.action;

import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.business.materialStock.info.MatockSetterBalance;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatockVisiEnforceBalance extends ActionVisitorTemplateEnforce<MatockInfo> {
	
	public MatockVisiEnforceBalance(DeciTreeOption<MatockInfo> option) {
		super(option);
	}
	
	
	
	@Override protected MatockInfo enforceHook(MatockInfo recordInfo) {
		InfoSetter<MatockInfo> attrSetter = new MatockSetterBalance();
		return attrSetter.setAttr(recordInfo);
	}
}
