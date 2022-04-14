package br.com.mind5.business.storeLunchTime.info;

import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.business.storeLunchTimeSearch.info.StuntmarchInfo;
import br.com.mind5.business.storeLunchTimeSnapshot.info.StuntmapInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class StuntmMerger {
	public static List<StuntmInfo> mergeWithStuntmap(List<StuntmInfo> baseInfos, List<StuntmapInfo> selectedInfos) {
		InfoMergerBuilder<StuntmInfo, StuntmapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StuntmMergerVisiStuntmap());
		InfoMerger<StuntmInfo, StuntmapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StuntmInfo> mergeWithSytotauh(List<StuntmInfo> baseInfos, List<SytotauhInfo> selectedInfos) {
		InfoMergerBuilder<StuntmInfo, SytotauhInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StuntmMergerVisiSytotauh());
		InfoMerger<StuntmInfo, SytotauhInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StuntmInfo> mergeWithStuntmarch(List<StuntmInfo> baseInfos, List<StuntmarchInfo> selectedInfos) {
		InfoMergerBuilder<StuntmInfo, StuntmarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StuntmMergerVisiStuntmarch());
		InfoMerger<StuntmInfo, StuntmarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StuntmInfo> mergeWithWeekday(List<StuntmInfo> baseInfos, List<WeekdayInfo> selectedInfos) {
		InfoMergerBuilder<StuntmInfo, WeekdayInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StuntmMergerVisiWeekday());
		InfoMerger<StuntmInfo, WeekdayInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StuntmInfo> mergeWithStolis(List<StuntmInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilder<StuntmInfo, StolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StuntmMergerVisiStolis());
		InfoMerger<StuntmInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StuntmInfo> mergeWithUsername(List<StuntmInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<StuntmInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StuntmMergerVisiUsername());
		InfoMerger<StuntmInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StuntmInfo> mergeToSelect(List<StuntmInfo> baseInfos, List<StuntmInfo> selectedInfos) {
		InfoMergerBuilder<StuntmInfo, StuntmInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StuntmMergerVisiToSelect());
		InfoMerger<StuntmInfo, StuntmInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StuntmInfo> mergeToDelete(List<StuntmInfo> baseInfos, List<StuntmInfo> selectedInfos) {
		InfoMergerBuilder<StuntmInfo, StuntmInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StuntmMergerVisiToDelete());
		InfoMerger<StuntmInfo, StuntmInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	

	public static List<StuntmInfo> mergeToUpdate(List<StuntmInfo> baseInfos, List<StuntmInfo> selectedInfos) {
		InfoMergerBuilder<StuntmInfo, StuntmInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StuntmMergerVisiToUpdate());
		InfoMerger<StuntmInfo, StuntmInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
