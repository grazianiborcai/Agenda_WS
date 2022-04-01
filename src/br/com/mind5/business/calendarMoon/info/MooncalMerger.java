package br.com.mind5.business.calendarMoon.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.masterData.moonPhase.info.MoonaseInfo;

public final class MooncalMerger {
	public static List<MooncalInfo> mergeWithMoonase(List<MooncalInfo> baseInfos, List<MoonaseInfo> selectedInfos) {
		InfoMergerBuilder<MooncalInfo, MoonaseInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MooncalMergerVisiMoonase());
		InfoMerger<MooncalInfo, MoonaseInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MooncalInfo> mergeToSelect(List<MooncalInfo> baseInfos, List<MooncalInfo> selectedInfos) {
		InfoMergerBuilder<MooncalInfo, MooncalInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MooncalMergerVisiToSelect());
		InfoMerger<MooncalInfo, MooncalInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
