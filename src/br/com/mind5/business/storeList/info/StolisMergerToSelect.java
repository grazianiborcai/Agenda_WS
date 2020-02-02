package br.com.mind5.business.storeList.info;

import java.util.List;

import br.com.mind5.info.InfoMergerTemplateV2;
import br.com.mind5.info.InfoUniquifier;

final class StolisMergerToSelect extends InfoMergerTemplateV2<StolisInfo, StolisInfo> {
	
	@Override protected StolisInfo writeHook(StolisInfo selectedInfo, StolisInfo baseInfo) {
		selectedInfo.codLanguage = baseInfo.codLanguage;
		selectedInfo.username = baseInfo.username;

		return selectedInfo;
	}
	
	
	
	@Override protected boolean shouldWriteHook(StolisInfo selectedInfo, StolisInfo baseInfo) {
		return (selectedInfo.codOwner == baseInfo.codOwner);
	}
	
	
	
	@Override protected List<StolisInfo> uniquifyHook(List<StolisInfo> results) {
		InfoUniquifier<StolisInfo> uniquifier = new StolisUniquifier();
		return uniquifier.uniquify(results);
	}
}
