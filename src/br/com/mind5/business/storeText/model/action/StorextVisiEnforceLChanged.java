package br.com.mind5.business.storeText.model.action;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeText.info.StorextSetterLChanged;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorextVisiEnforceLChanged extends ActionVisitorTemplateEnforce<StorextInfo> {
	
	public StorextVisiEnforceLChanged(DeciTreeOption<StorextInfo> option) {
		super(option);
	}
	
	
	
	@Override protected StorextInfo enforceHook(StorextInfo recordInfo) {
		InfoSetter<StorextInfo> attrSetter = new StorextSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
