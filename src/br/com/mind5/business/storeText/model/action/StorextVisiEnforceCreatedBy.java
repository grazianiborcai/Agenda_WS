package br.com.mind5.business.storeText.model.action;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeText.info.StorextSetterCreatedBy;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorextVisiEnforceCreatedBy extends ActionVisitorTemplateEnforce<StorextInfo> {
	
	public StorextVisiEnforceCreatedBy(DeciTreeOption<StorextInfo> option) {
		super(option);
	}
	
	
	
	@Override protected StorextInfo enforceHook(StorextInfo recordInfo) {
		InfoSetter<StorextInfo> attrSetter = new StorextSetterCreatedBy();
		return attrSetter.setAttr(recordInfo);
	}
}
