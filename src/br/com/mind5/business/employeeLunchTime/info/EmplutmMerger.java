package br.com.mind5.business.employeeLunchTime.info;

import java.util.List;

import br.com.mind5.business.employeeLunchTimeSearch.info.EmplutmarchInfo;
import br.com.mind5.business.employeeLunchTimeSnapshot.info.EmplutmapInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class EmplutmMerger {	
	public static List<EmplutmInfo> mergeWithEmplutmap(List<EmplutmInfo> baseInfos, List<EmplutmapInfo> selectedInfos) {
		InfoMergerBuilder<EmplutmInfo, EmplutmapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmplutmMergerVisiEmplutmap());
		InfoMerger<EmplutmInfo, EmplutmapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmplutmInfo> mergeWithEmplutmarch(List<EmplutmInfo> baseInfos, List<EmplutmarchInfo> selectedInfos) {
		InfoMergerBuilder<EmplutmInfo, EmplutmarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmplutmMergerVisiEmplutmarch());
		InfoMerger<EmplutmInfo, EmplutmarchInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<EmplutmInfo> mergeWithStolis(List<EmplutmInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilder<EmplutmInfo, StolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmplutmMergerVisiStolis());
		InfoMerger<EmplutmInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<EmplutmInfo> mergeWithUsername(List<EmplutmInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<EmplutmInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmplutmMergerVisiUsername());
		InfoMerger<EmplutmInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmplutmInfo> mergeWithWeekday(List<EmplutmInfo> baseInfos, List<WeekdayInfo> selectedInfos) {
		InfoMergerBuilder<EmplutmInfo, WeekdayInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmplutmMergerVisiWeekday());
		InfoMerger<EmplutmInfo, WeekdayInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmplutmInfo> mergeToDelete(List<EmplutmInfo> baseInfos, List<EmplutmInfo> selectedInfos) {
		InfoMergerBuilder<EmplutmInfo, EmplutmInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmplutmMergerVisiToDelete());
		InfoMerger<EmplutmInfo, EmplutmInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmplutmInfo> mergeToSelect(List<EmplutmInfo> baseInfos, List<EmplutmInfo> selectedInfos) {
		InfoMergerBuilder<EmplutmInfo, EmplutmInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmplutmMergerVisiToSelect());
		InfoMerger<EmplutmInfo, EmplutmInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
