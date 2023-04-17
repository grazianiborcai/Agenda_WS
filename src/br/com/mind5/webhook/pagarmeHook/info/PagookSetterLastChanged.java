package br.com.mind5.webhook.pagarmeHook.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class PagookSetterLastChanged extends InfoSetterTemplate<PagookInfo> {
	
	@Override protected PagookInfo setAttrHook(PagookInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
