package br.com.mind5.webhook.pagarmeHook.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class PagookSetterIsRefreshedOff extends InfoSetterTemplate<PagookInfo> {
	
	@Override protected PagookInfo setAttrHook(PagookInfo recordInfo) {
		recordInfo.isRefreshed = false;
		return recordInfo;
	}
}
