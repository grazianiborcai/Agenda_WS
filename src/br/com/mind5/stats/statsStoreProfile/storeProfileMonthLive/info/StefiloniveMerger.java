package br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.info;

import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class StefiloniveMerger {
	public static List<StefiloniveInfo> mergeWithSytotauh(List<StefiloniveInfo> baseInfos, List<SytotauhInfo> selectedInfos) {
		InfoMergerBuilder<StefiloniveInfo, SytotauhInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StefiloniveMergerVisiSytotauh());
		InfoMerger<StefiloniveInfo, SytotauhInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StefiloniveInfo> mergeWithCalonth(List<StefiloniveInfo> baseInfos, List<CalonthInfo> selectedInfos) {
		InfoMergerBuilder<StefiloniveInfo, CalonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StefiloniveMergerVisiCalonth());
		InfoMerger<StefiloniveInfo, CalonthInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StefiloniveInfo> mergeToSelect(List<StefiloniveInfo> baseInfos, List<StefiloniveInfo> selectedInfos) {
		InfoMergerBuilder<StefiloniveInfo, StefiloniveInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StefiloniveMergerVisiToSelect());
		InfoMerger<StefiloniveInfo, StefiloniveInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
