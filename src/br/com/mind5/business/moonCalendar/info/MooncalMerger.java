package br.com.mind5.business.moonCalendar.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.moonPhase.info.MoonaseInfo;

public final class MooncalMerger {
	public static List<MooncalInfo> mergeWithMoonase(List<MooncalInfo> baseInfos, List<MoonaseInfo> selectedInfos) {
		InfoMergerBuilderV3<MooncalInfo, MoonaseInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MooncalVisiMergeMoonase());
		InfoMergerV3<MooncalInfo, MoonaseInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MooncalInfo> mergeToSelect(List<MooncalInfo> baseInfos, List<MooncalInfo> selectedInfos) {
		InfoMergerBuilderV3<MooncalInfo, MooncalInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MooncalVisiMergeToSelect());
		InfoMergerV3<MooncalInfo, MooncalInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
