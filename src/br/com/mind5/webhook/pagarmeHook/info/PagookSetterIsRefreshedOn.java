package br.com.mind5.webhook.pagarmeHook.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class PagookSetterIsRefreshedOn extends InfoSetterTemplate<PagookInfo> {
	
	@Override protected PagookInfo setAttrHook(PagookInfo recordInfo) {
		recordInfo.createdOn = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
