package br.com.mind5.business.storeWorkTime.info;

import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.business.storeWorkTimeSnapshot.info.StowotmapInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class StowotmMerger {
	public static List<StowotmInfo> mergeWithStowotmap(List<StowotmInfo> baseInfos, List<StowotmapInfo> selectedInfos) {
		InfoMergerBuilder<StowotmInfo, StowotmapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StowotmMergerVisiStowotmap());
		InfoMerger<StowotmInfo, StowotmapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StowotmInfo> mergeWithSytotauh(List<StowotmInfo> baseInfos, List<SytotauhInfo> selectedInfos) {
		InfoMergerBuilder<StowotmInfo, SytotauhInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StowotmMergerVisiSytotauh());
		InfoMerger<StowotmInfo, SytotauhInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StowotmInfo> mergeWithStowotarch(List<StowotmInfo> baseInfos, List<StowotarchInfo> selectedInfos) {
		InfoMergerBuilder<StowotmInfo, StowotarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StowotmMergerVisiStowotarch());
		InfoMerger<StowotmInfo, StowotarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StowotmInfo> mergeWithWeekday(List<StowotmInfo> baseInfos, List<WeekdayInfo> selectedInfos) {
		InfoMergerBuilder<StowotmInfo, WeekdayInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StowotmMergerVisiWeekday());
		InfoMerger<StowotmInfo, WeekdayInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StowotmInfo> mergeWithWeekdayFallback(List<StowotmInfo> baseInfos, List<WeekdayInfo> selectedInfos) {
		InfoMergerBuilder<StowotmInfo, WeekdayInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StowotmMergerVisiWeekdayFallback());
		InfoMerger<StowotmInfo, WeekdayInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StowotmInfo> mergeWithStolis(List<StowotmInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilder<StowotmInfo, StolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StowotmMergerVisiStolis());
		InfoMerger<StowotmInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StowotmInfo> mergeWithUsername(List<StowotmInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<StowotmInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StowotmMergerVisiUsername());
		InfoMerger<StowotmInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StowotmInfo> mergeToSelect(List<StowotmInfo> baseInfos, List<StowotmInfo> selectedInfos) {
		InfoMergerBuilder<StowotmInfo, StowotmInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StowotmMergerVisiToSelect());
		InfoMerger<StowotmInfo, StowotmInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StowotmInfo> mergeToDelete(List<StowotmInfo> baseInfos, List<StowotmInfo> selectedInfos) {
		InfoMergerBuilder<StowotmInfo, StowotmInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StowotmMergerVisiToDelete());
		InfoMerger<StowotmInfo, StowotmInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	

	public static List<StowotmInfo> mergeToUpdate(List<StowotmInfo> baseInfos, List<StowotmInfo> selectedInfos) {
		InfoMergerBuilder<StowotmInfo, StowotmInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StowotmMergerVisiToUpdate());
		InfoMerger<StowotmInfo, StowotmInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
