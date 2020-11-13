package br.com.mind5.business.storeWorkTime.info;

import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class StowotmMerger {
	public static List<StowotmInfo> mergeWithSytotauh(List<StowotmInfo> baseInfos, List<SytotauhInfo> selectedInfos) {
		InfoMergerBuilder<StowotmInfo, SytotauhInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StowotmVisiMergeSytotauh());
		InfoMerger<StowotmInfo, SytotauhInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StowotmInfo> mergeWithStowotarch(List<StowotmInfo> baseInfos, List<StowotarchInfo> selectedInfos) {
		InfoMergerBuilder<StowotmInfo, StowotarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StowotmVisiMergeStowotarch());
		InfoMerger<StowotmInfo, StowotarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StowotmInfo> mergeWithWeekday(List<StowotmInfo> baseInfos, List<WeekdayInfo> selectedInfos) {
		InfoMergerBuilder<StowotmInfo, WeekdayInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StowotmVisiMergeWeekday());
		InfoMerger<StowotmInfo, WeekdayInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StowotmInfo> mergeWithStolis(List<StowotmInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilder<StowotmInfo, StolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StowotmVisiMergeStolis());
		InfoMerger<StowotmInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StowotmInfo> mergeWithUsername(List<StowotmInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<StowotmInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StowotmVisiMergeUsername());
		InfoMerger<StowotmInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StowotmInfo> mergeToSelect(List<StowotmInfo> baseInfos, List<StowotmInfo> selectedInfos) {
		InfoMergerBuilder<StowotmInfo, StowotmInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StowotmVisiMergeToSelect());
		InfoMerger<StowotmInfo, StowotmInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StowotmInfo> mergeToDelete(List<StowotmInfo> baseInfos, List<StowotmInfo> selectedInfos) {
		InfoMergerBuilder<StowotmInfo, StowotmInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StowotmVisiMergeToDelete());
		InfoMerger<StowotmInfo, StowotmInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	

	public static List<StowotmInfo> mergeToUpdate(List<StowotmInfo> baseInfos, List<StowotmInfo> selectedInfos) {
		InfoMergerBuilder<StowotmInfo, StowotmInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StowotmVisiMergeToUpdate());
		InfoMerger<StowotmInfo, StowotmInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
