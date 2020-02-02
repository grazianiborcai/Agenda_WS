package br.com.mind5.business.planningTime.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerTemplateV2;
import br.com.mind5.info.InfoUniquifier;

final class PlanimeMergerStolis extends InfoMergerTemplateV2<PlanimeInfo, StolisInfo> {

	@Override protected PlanimeInfo writeHook(StolisInfo selectedInfo, PlanimeInfo baseInfo) {
		baseInfo.stolises.add(selectedInfo);
		return baseInfo;
	}
	
	
	
	@Override protected boolean shouldWriteHook(StolisInfo selectedInfo, PlanimeInfo baseInfo) {
		return (selectedInfo.codOwner == baseInfo.codOwner);
	}
	
	
	
	@Override protected List<PlanimeInfo> uniquifyHook(List<PlanimeInfo> results) {
		InfoUniquifier<PlanimeInfo> uniquifier = new PlanimeUniquifier();
		return uniquifier.uniquify(results);
	}
	
	
	
	@Override protected List<PlanimeInfo> beforeWriteHook(List<PlanimeInfo> baseInfos) {
		for (PlanimeInfo eachBase : baseInfos) {
			eachBase.stolises = new ArrayList<>();
		}
		
		return baseInfos;
	}
}
