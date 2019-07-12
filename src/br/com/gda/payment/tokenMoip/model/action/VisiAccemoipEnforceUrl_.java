package br.com.gda.payment.tokenMoip.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.payment.tokenMoip.info.TokemoipInfo;
import br.com.gda.payment.tokenMoip.info.AccemoipSetterUrl;

final class VisiAccemoipEnforceUrl_ extends ActionVisitorTemplateEnforce<TokemoipInfo> {
	
	@Override protected TokemoipInfo enforceHook(TokemoipInfo recordInfo) {
		InfoSetter<TokemoipInfo> attrSetter = new AccemoipSetterUrl();
		return attrSetter.setAttr(recordInfo);
	}
}
