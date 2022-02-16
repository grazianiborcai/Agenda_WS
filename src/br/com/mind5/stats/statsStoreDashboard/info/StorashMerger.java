package br.com.mind5.stats.statsStoreDashboard.info;

import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.info.SteddInfo;

public final class StorashMerger {
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
