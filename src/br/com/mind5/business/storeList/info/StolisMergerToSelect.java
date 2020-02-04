package br.com.mind5.business.storeList.info;

import java.util.List;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplateV2_;

final class StolisMergerToSelect extends InfoMergerTemplateV2_<StolisInfo, StolisInfo> {
	
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
