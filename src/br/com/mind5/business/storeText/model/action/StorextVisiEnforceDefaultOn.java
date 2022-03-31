package br.com.mind5.business.storeText.model.action;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeText.info.StorextSetterDefaultOn;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorextVisiEnforceDefaultOn extends ActionVisitorTemplateEnforce<StorextInfo> {
	
	public StorextVisiEnforceDefaultOn(DeciTreeOption<StorextInfo> option) {
		super(option);
	}
	
	
	
	@Override protected StorextInfo enforceHook(StorextInfo recordInfo) {
		InfoSetter<StorextInfo> attrSetter = new StorextSetterDefaultOn();
		return attrSetter.setAttr(recordInfo);
	}
}
