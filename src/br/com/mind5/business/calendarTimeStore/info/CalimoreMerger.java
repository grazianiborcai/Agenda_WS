package br.com.mind5.business.calendarTimeStore.info;

import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class CalimoreMerger {
	public static List<CalimoreInfo> mergeWithCalate(List<CalimoreInfo> baseInfos, List<CalateInfo> selectedInfos) {
		InfoMergerBuilderV3<CalimoreInfo, CalateInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CalimoreVisiMergeCalate());
		InfoMergerV3<CalimoreInfo, CalateInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CalimoreInfo> mergeWithStowotarch(List<CalimoreInfo> baseInfos, List<StowotarchInfo> selectedInfos) {
		InfoMergerBuilderV3<CalimoreInfo, StowotarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CalimoreVisiMergeStowotarch());
		InfoMergerV3<CalimoreInfo, StowotarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
