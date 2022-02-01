package br.com.mind5.business.calendarMonth.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.month.info.MonthInfo;

public final class CalonthMerger {
	public static List<CalonthInfo> mergeWithMonth(List<CalonthInfo> baseInfos, List<MonthInfo> selectedInfos) {
		InfoMergerBuilder<CalonthInfo, MonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CalonthVisiMergeMonth());
		InfoMerger<CalonthInfo, MonthInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CalonthInfo> mergeToSelect(List<CalonthInfo> baseInfos, List<CalonthInfo> selectedInfos) {
		InfoMergerBuilder<CalonthInfo, CalonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CalonthVisiMergeToSelect());
		InfoMerger<CalonthInfo, CalonthInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
