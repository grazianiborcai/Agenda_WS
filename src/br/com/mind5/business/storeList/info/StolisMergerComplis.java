package br.com.mind5.business.storeList.info;

import java.util.List;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.info.InfoMergerTemplateV2;
import br.com.mind5.info.InfoUniquifier;

final class StolisMergerComplis extends InfoMergerTemplateV2<StolisInfo, ComplisInfo> {

	@Override protected StolisInfo writeHook(ComplisInfo selectedInfo, StolisInfo baseInfo) {
		baseInfo.complisData = selectedInfo;
		
		return baseInfo;
	}
	
	
	
	@Override protected boolean shouldWriteHook(ComplisInfo selectedInfo, StolisInfo baseInfo) {
		return (selectedInfo.codOwner == baseInfo.codOwner);
	}
	
	
	
	@Override protected List<StolisInfo> uniquifyHook(List<StolisInfo> results) {
		InfoUniquifier<StolisInfo> uniquifier = new StolisUniquifier();
		return uniquifier.uniquify(results);
	}
}
