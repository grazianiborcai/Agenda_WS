package br.com.mind5.business.storeList.info;

import java.util.List;

import br.com.mind5.business.masterData.info.TimezoneInfo;
import br.com.mind5.info.InfoMergerTemplateV2;
import br.com.mind5.info.InfoUniquifier;

final class StolisMergerTimezone extends InfoMergerTemplateV2<StolisInfo, TimezoneInfo> {

	@Override protected StolisInfo writeHook(TimezoneInfo selectedInfo, StolisInfo baseInfo) {
		baseInfo.txtTimezone = selectedInfo.txtTimezone;

		return baseInfo;
	}
	
	
	
	@Override protected boolean shouldWriteHook(TimezoneInfo selectedInfo, StolisInfo baseInfo) {
		return (selectedInfo.codTimezone.equals(baseInfo.codTimezone));
	}
	
	
	
	@Override protected List<StolisInfo> uniquifyHook(List<StolisInfo> results) {
		InfoUniquifier<StolisInfo> uniquifier = new StolisUniquifier();
		return uniquifier.uniquify(results);
	}
}
