package br.com.mind5.business.orderHistoryDecorated.info;

import java.util.List;

import br.com.mind5.business.orderHistory.info.OrdoryInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYear.info.StusoryInfo;

public final class OrdorycoMerger {	
	public static List<OrdorycoInfo> mergeWithStusory(List<OrdorycoInfo> baseInfos, List<StusoryInfo> selectedInfos) {
		InfoMergerBuilder<OrdorycoInfo, StusoryInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdorycoMergerVisiStusory());
		InfoMerger<OrdorycoInfo, StusoryInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OrdorycoInfo> mergeWithOrdory(List<OrdorycoInfo> baseInfos, List<OrdoryInfo> selectedInfos) {
		InfoMergerBuilder<OrdorycoInfo, OrdoryInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdorycoMergerVisiOrdory());
		InfoMerger<OrdorycoInfo, OrdoryInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OrdorycoInfo> mergeWithUsername(List<OrdorycoInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<OrdorycoInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdorycoMergerVisiUsername());
		InfoMerger<OrdorycoInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
