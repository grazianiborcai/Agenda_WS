package br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.info;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.info.CutefilonagrInfo;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.info.CutefiloniveInfo;

public final class CutefilonMerger {
	public static List<CutefilonInfo> mergeWithCalonth(List<CutefilonInfo> baseInfos, List<CalonthInfo> selectedInfos) {
		InfoMergerBuilder<CutefilonInfo, CalonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CutefilonMergerVisiCalonth());
		InfoMerger<CutefilonInfo, CalonthInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CutefilonInfo> mergeWithCutefilonagr(List<CutefilonInfo> baseInfos, List<CutefilonagrInfo> selectedInfos) {
		InfoMergerBuilder<CutefilonInfo, CutefilonagrInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CutefilonMergerVisiCutefilonagr());
		InfoMerger<CutefilonInfo, CutefilonagrInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CutefilonInfo> mergeWithCutefilonive(List<CutefilonInfo> baseInfos, List<CutefiloniveInfo> selectedInfos) {
		InfoMergerBuilder<CutefilonInfo, CutefiloniveInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CutefilonMergerVisiCutefilonive());
		InfoMerger<CutefilonInfo, CutefiloniveInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
