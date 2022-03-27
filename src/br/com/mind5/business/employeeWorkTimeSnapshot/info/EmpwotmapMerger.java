package br.com.mind5.business.employeeWorkTimeSnapshot.info;

import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;

public final class EmpwotmapMerger {
	public static List<EmpwotmapInfo> mergeWithStolis(List<EmpwotmapInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilder<EmpwotmapInfo, StolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpwotmapMergerVisiStolis());
		InfoMerger<EmpwotmapInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<EmpwotmapInfo> mergeWithWeekday(List<EmpwotmapInfo> baseInfos, List<WeekdayInfo> selectedInfos) {
		InfoMergerBuilder<EmpwotmapInfo, WeekdayInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpwotmapMergerVisiWeekday());
		InfoMerger<EmpwotmapInfo, WeekdayInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpwotmapInfo> mergeToSelect(List<EmpwotmapInfo> baseInfos, List<EmpwotmapInfo> selectedInfos) {
		InfoMergerBuilder<EmpwotmapInfo, EmpwotmapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpwotmapMergerVisiToSelect());
		InfoMerger<EmpwotmapInfo, EmpwotmapInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
