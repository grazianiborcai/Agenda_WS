package br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.info;

import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class CutefiloniveMerger {
	public static List<CutefiloniveInfo> mergeWithSytotauh(List<CutefiloniveInfo> baseInfos, List<SytotauhInfo> selectedInfos) {
		InfoMergerBuilder<CutefiloniveInfo, SytotauhInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CutefiloniveMergerVisiSytotauh());
		InfoMerger<CutefiloniveInfo, SytotauhInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CutefiloniveInfo> mergeWithCalonth(List<CutefiloniveInfo> baseInfos, List<CalonthInfo> selectedInfos) {
		InfoMergerBuilder<CutefiloniveInfo, CalonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CutefiloniveMergerVisiCalonth());
		InfoMerger<CutefiloniveInfo, CalonthInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CutefiloniveInfo> mergeToSelect(List<CutefiloniveInfo> baseInfos, List<CutefiloniveInfo> selectedInfos) {
		InfoMergerBuilder<CutefiloniveInfo, CutefiloniveInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CutefiloniveMergerVisiToSelect());
		InfoMerger<CutefiloniveInfo, CutefiloniveInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
