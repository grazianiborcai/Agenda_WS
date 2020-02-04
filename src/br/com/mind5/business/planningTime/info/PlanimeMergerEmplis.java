package br.com.mind5.business.planningTime.info;

import java.util.ArrayList;
import java.util.List;
import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplateV2_;

final class PlanimeMergerEmplis extends InfoMergerTemplateV2_<PlanimeInfo, EmplisInfo> {
	
	@Override protected PlanimeInfo writeHook(EmplisInfo selectedInfo, PlanimeInfo baseInfo) {
		baseInfo.emplises.add(selectedInfo);
		return baseInfo;
	}
	
	
	
	@Override protected boolean shouldWriteHook(EmplisInfo selectedInfo, PlanimeInfo baseInfo) {
		return (selectedInfo.codOwner == baseInfo.codOwner);
	}
	
	
	
	@Override protected List<PlanimeInfo> uniquifyHook(List<PlanimeInfo> results) {
		InfoUniquifier<PlanimeInfo> uniquifier = new PlanimeUniquifier();
		return uniquifier.uniquify(results);
	}
	
	
	
	@Override protected List<PlanimeInfo> beforeWriteHook(List<PlanimeInfo> baseInfos) {
		for (PlanimeInfo eachBase : baseInfos) {
			eachBase.emplises = new ArrayList<>();
		}
		
		return baseInfos;
	}
}
