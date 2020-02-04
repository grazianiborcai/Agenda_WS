package br.com.mind5.business.planningTime.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplateV2_;

final class PlanimeMergerMatlis extends InfoMergerTemplateV2_<PlanimeInfo, MatlisInfo> {
	@Override protected PlanimeInfo writeHook(MatlisInfo selectedInfo, PlanimeInfo baseInfo) {
		baseInfo.matlises.add(selectedInfo);
		return baseInfo;
	}
	
	
	
	@Override protected boolean shouldWriteHook(MatlisInfo selectedInfo, PlanimeInfo baseInfo) {
		return (selectedInfo.codOwner == baseInfo.codOwner);
	}
	
	
	
	@Override protected List<PlanimeInfo> uniquifyHook(List<PlanimeInfo> results) {
		InfoUniquifier<PlanimeInfo> uniquifier = new PlanimeUniquifier();
		return uniquifier.uniquify(results);
	}
	
	
	
	@Override protected List<PlanimeInfo> beforeWriteHook(List<PlanimeInfo> baseInfos) {
		for (PlanimeInfo eachBase : baseInfos) {
			eachBase.matlises = new ArrayList<>();
		}
		
		return baseInfos;
	}
}
