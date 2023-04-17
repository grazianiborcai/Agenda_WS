package br.com.mind5.webhook.pagarmeHook.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.webhook.pagarmeHook.info.PagookInfo;
import br.com.mind5.webhook.pagarmeHook.info.PagookSetterLastChanged;

public final class PagookVisiEnforceLastChanged extends ActionVisitorTemplateEnforce<PagookInfo> {
	
	public PagookVisiEnforceLastChanged(DeciTreeOption<PagookInfo> option) {
		super(option);
	}
	
	
	
	@Override protected PagookInfo enforceHook(PagookInfo recordInfo) {
		InfoSetter<PagookInfo> attrSetter = new PagookSetterLastChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
