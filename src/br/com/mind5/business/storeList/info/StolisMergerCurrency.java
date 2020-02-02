package br.com.mind5.business.storeList.info;

import java.util.List;

import br.com.mind5.business.masterData.info.CurrencyInfo;
import br.com.mind5.info.InfoMergerTemplateV2;
import br.com.mind5.info.InfoUniquifier;

final class StolisMergerCurrency extends InfoMergerTemplateV2<StolisInfo, CurrencyInfo> {

	@Override protected StolisInfo writeHook(CurrencyInfo selectedInfo, StolisInfo baseInfo) {
		baseInfo.txtCurr = selectedInfo.txtCurr;

		return baseInfo;
	}
	
	
	
	@Override protected boolean shouldWriteHook(CurrencyInfo selectedInfo, StolisInfo baseInfo) {
		return (selectedInfo.codCurr.equals(baseInfo.codCurr));
	}
	
	
	
	@Override protected List<StolisInfo> uniquifyHook(List<StolisInfo> results) {
		InfoUniquifier<StolisInfo> uniquifier = new StolisUniquifier();
		return uniquifier.uniquify(results);
	}
}
