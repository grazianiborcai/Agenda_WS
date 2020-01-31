package br.com.mind5.business.planningTime.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.WeekdayInfo;
import br.com.mind5.info.InfoMergerTemplateV2;
import br.com.mind5.info.InfoUniquifier;

final class PlanimeMergerWeekday extends InfoMergerTemplateV2<PlanimeInfo, WeekdayInfo> {

	@Override protected PlanimeInfo writeHook(WeekdayInfo selectedInfo, PlanimeInfo baseInfo) {
		baseInfo.weekdays.add(selectedInfo);
		return baseInfo;
	}
	
	
	
	@Override protected boolean shouldWriteHook(WeekdayInfo selectedInfo, PlanimeInfo baseInfo) {
		return true;
	}
	
	
	
	@Override protected List<PlanimeInfo> uniquifyHook(List<PlanimeInfo> results) {
		InfoUniquifier<PlanimeInfo> uniquifier = new PlanimeUniquifier();
		return uniquifier.uniquify(results);
	}
	
	
	
	@Override protected List<PlanimeInfo> beforeWriteHook(List<PlanimeInfo> baseInfos) {
		for (PlanimeInfo eachBase : baseInfos) {
			eachBase.weekdays = new ArrayList<>();
		}
		
		return baseInfos;
	}
}
