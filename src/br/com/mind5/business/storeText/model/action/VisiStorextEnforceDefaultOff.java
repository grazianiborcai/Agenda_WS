package br.com.mind5.business.storeText.model.action;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeText.info.StorextSetterDefaultOff;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStorextEnforceDefaultOff extends ActionVisitorTemplateEnforceV2<StorextInfo> {
	
	public VisiStorextEnforceDefaultOff(DeciTreeOption<StorextInfo> option) {
		super(option);
	}
	
	
	
	@Override protected StorextInfo enforceHook(StorextInfo recordInfo) {
		InfoSetter<StorextInfo> attrSetter = new StorextSetterDefaultOff();
		return attrSetter.setAttr(recordInfo);
	}
}
