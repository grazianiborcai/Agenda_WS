package br.com.mind5.stats.statsStoreDashboard.info;

import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.info.StordInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonth.info.StoronInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.info.SteddInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.info.StedmonInfo;

public final class StorashMerger {
	public static List<StorashInfo> mergeWithStoron(List<StorashInfo> baseInfos, List<StoronInfo> selectedInfos) {
		InfoMergerBuilder<StorashInfo, StoronInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorashVisiMergeStoron());
		InfoMerger<StorashInfo, StoronInfo> merger = builder.build();
	
		return merger.merge();
	}
	
	
	public static List<StorashInfo> mergeWithStord(List<StorashInfo> baseInfos, List<StordInfo> selectedInfos) {
		InfoMergerBuilder<StorashInfo, StordInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorashVisiMergeStord());
		InfoMerger<StorashInfo, StordInfo> merger = builder.build();
	
		return merger.merge();
	}
	
	
	public static List<StorashInfo> mergeWithStedmonLtm(List<StorashInfo> baseInfos, List<StedmonInfo> selectedInfos) {
		InfoMergerBuilder<StorashInfo, StedmonInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorashVisiMergeStedmonLtm());
		InfoMerger<StorashInfo, StedmonInfo> merger = builder.build();
	
		return merger.merge();
	}
	
	
	
	public static List<StorashInfo> mergeWithStedmon(List<StorashInfo> baseInfos, List<StedmonInfo> selectedInfos) {
		InfoMergerBuilder<StorashInfo, StedmonInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorashVisiMergeStedmon());
		InfoMerger<StorashInfo, StedmonInfo> merger = builder.build();
	
		return merger.merge();
	}
	
	
	
	public static List<StorashInfo> mergeWithStedd(List<StorashInfo> baseInfos, List<SteddInfo> selectedInfos) {
		InfoMergerBuilder<StorashInfo, SteddInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorashVisiMergeStedd());
		InfoMerger<StorashInfo, SteddInfo> merger = builder.build();
	
		return merger.merge();
	}
	
	
	
	public static List<StorashInfo> mergeWithSytotauh(List<StorashInfo> baseInfos, List<SytotauhInfo> selectedInfos) {
		InfoMergerBuilder<StorashInfo, SytotauhInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorashVisiMergeSytotauh());
		InfoMerger<StorashInfo, SytotauhInfo> merger = builder.build();
	
		return merger.merge();
	}
}
