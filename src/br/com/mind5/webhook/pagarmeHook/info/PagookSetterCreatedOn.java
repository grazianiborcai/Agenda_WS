package br.com.mind5.webhook.pagarmeHook.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class PagookSetterCreatedOn extends InfoSetterTemplate<PagookInfo> {
	
	@Override protected PagookInfo setAttrHook(PagookInfo recordInfo) {
		recordInfo.isRefreshed = true;
		return recordInfo;
	}
}
