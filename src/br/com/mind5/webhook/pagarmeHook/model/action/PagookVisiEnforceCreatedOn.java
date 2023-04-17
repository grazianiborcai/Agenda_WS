package br.com.mind5.webhook.pagarmeHook.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.webhook.pagarmeHook.info.PagookInfo;
import br.com.mind5.webhook.pagarmeHook.info.PagookSetterCreatedOn;

public final class PagookVisiEnforceCreatedOn extends ActionVisitorTemplateEnforce<PagookInfo> {
	
	public PagookVisiEnforceCreatedOn(DeciTreeOption<PagookInfo> option) {
		super(option);
	}
	
	
	
	@Override protected PagookInfo enforceHook(PagookInfo recordInfo) {
		InfoSetter<PagookInfo> attrSetter = new PagookSetterCreatedOn();
		return attrSetter.setAttr(recordInfo);
	}
}
