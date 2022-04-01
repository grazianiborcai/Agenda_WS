package br.com.mind5.business.calendarTimeStore.info;

import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.storeLeaveDateRange.info.StolargInfo;
import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class CalimoreMerger {
	public static List<CalimoreInfo> mergeWithStolarg(List<CalimoreInfo> baseInfos, List<StolargInfo> selectedInfos) {
		InfoMergerBuilder<CalimoreInfo, StolargInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CalimoreMergeVisiStolarg());
		InfoMerger<CalimoreInfo, StolargInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CalimoreInfo> mergeWithCalate(List<CalimoreInfo> baseInfos, List<CalateInfo> selectedInfos) {
		InfoMergerBuilder<CalimoreInfo, CalateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CalimoreMergeVisiCalate());
		InfoMerger<CalimoreInfo, CalateInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CalimoreInfo> mergeWithStowotarch(List<CalimoreInfo> baseInfos, List<StowotarchInfo> selectedInfos) {
		InfoMergerBuilder<CalimoreInfo, StowotarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CalimoreMergeVisiStowotarch());
		InfoMerger<CalimoreInfo, StowotarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
