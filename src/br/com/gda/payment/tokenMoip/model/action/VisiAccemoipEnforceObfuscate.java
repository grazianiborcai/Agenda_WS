package br.com.gda.payment.tokenMoip.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.payment.tokenMoip.info.TokemoipInfo;
import br.com.gda.payment.tokenMoip.info.AccemoipSetterObfuscate;

final class VisiAccemoipEnforceObfuscate extends ActionVisitorTemplateEnforce<TokemoipInfo> {
	
	@Override protected TokemoipInfo enforceHook(TokemoipInfo recordInfo) {
		InfoSetter<TokemoipInfo> attrSetter = new AccemoipSetterObfuscate();
		return attrSetter.setAttr(recordInfo);
	}
}
