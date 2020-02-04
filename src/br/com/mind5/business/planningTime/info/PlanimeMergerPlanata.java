package br.com.mind5.business.planningTime.info;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplateV2_;

final class PlanimeMergerPlanata extends InfoMergerTemplateV2_<PlanimeInfo, PlanataInfo> {

	@Override protected PlanimeInfo writeHook(PlanataInfo selectedInfo, PlanimeInfo baseInfo) {
		baseInfo.planatas.add(selectedInfo);
		baseInfo.dates.add(selectedInfo.date);
		return baseInfo;
	}
	
	
	
	@Override protected boolean shouldWriteHook(PlanataInfo selectedInfo, PlanimeInfo baseInfo) {
		return (selectedInfo.codOwner == baseInfo.codOwner);
	}
	
	
	
	@Override protected List<PlanimeInfo> uniquifyHook(List<PlanimeInfo> results) {
		InfoUniquifier<PlanimeInfo> uniquifier = new PlanimeUniquifier();
		return uniquifier.uniquify(results);
	}
	
	
	
	@Override protected List<PlanimeInfo> beforeWriteHook(List<PlanimeInfo> baseInfos) {
		for (PlanimeInfo eachBase : baseInfos) {
			eachBase.planatas = new ArrayList<>();
			eachBase.dates = new ArrayList<>();
		}
		
		return baseInfos;
	}
}
