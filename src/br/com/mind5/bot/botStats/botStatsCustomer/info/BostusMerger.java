package br.com.mind5.bot.botStats.botStatsCustomer.info;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.security.user.info.UserInfo;

public final class BostusMerger {
	public static List<BostusInfo> mergeWithDaemon(List<BostusInfo> baseInfos, List<UserInfo> selectedInfos) {
		InfoMergerBuilder<BostusInfo, UserInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new BostusMergerVisiDaemon());
		InfoMerger<BostusInfo, UserInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<BostusInfo> mergeWithCalonth(List<BostusInfo> baseInfos, List<CalonthInfo> selectedInfos) {
		InfoMergerBuilder<BostusInfo, CalonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new BostusMergerVisiCalonth());
		InfoMerger<BostusInfo, CalonthInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<BostusInfo> mergeWithStolis(List<BostusInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilder<BostusInfo, StolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new BostusMergerVisiCuslis());
		InfoMerger<BostusInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
