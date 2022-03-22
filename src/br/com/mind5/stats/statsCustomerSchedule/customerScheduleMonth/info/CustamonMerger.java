package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.info;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.info.CustamonagrInfo;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.info.CustamoniveInfo;

public final class CustamonMerger {
	public static List<CustamonInfo> mergeWithAddress(List<CustamonInfo> baseInfos, List<AddressInfo> selectedInfos) {
		InfoMergerBuilder<CustamonInfo, AddressInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CustamonMergerVisiAddress());
		InfoMerger<CustamonInfo, AddressInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CustamonInfo> mergeWithCalonth(List<CustamonInfo> baseInfos, List<CalonthInfo> selectedInfos) {
		InfoMergerBuilder<CustamonInfo, CalonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CustamonMergerVisiCalonth());
		InfoMerger<CustamonInfo, CalonthInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CustamonInfo> mergeWithStedmonagr(List<CustamonInfo> baseInfos, List<CustamonagrInfo> selectedInfos) {
		InfoMergerBuilder<CustamonInfo, CustamonagrInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CustamonMergerVisiCustamonagr());
		InfoMerger<CustamonInfo, CustamonagrInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CustamonInfo> mergeWithCuslis(List<CustamonInfo> baseInfos, List<CuslisInfo> selectedInfos) {
		InfoMergerBuilder<CustamonInfo, CuslisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CustamonMergerVisiCuslis());
		InfoMerger<CustamonInfo, CuslisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CustamonInfo> mergeWithStedmonive(List<CustamonInfo> baseInfos, List<CustamoniveInfo> selectedInfos) {
		InfoMergerBuilder<CustamonInfo, CustamoniveInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CustamonMergerVisiCustamonive());
		InfoMerger<CustamonInfo, CustamoniveInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
