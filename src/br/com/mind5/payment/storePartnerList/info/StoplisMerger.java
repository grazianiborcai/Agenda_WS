package br.com.mind5.payment.storePartnerList.info;

import java.util.List;

import br.com.mind5.business.masterData.info.PayparInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.payment.storePartnerSearch.info.StoparchInfo;

public final class StoplisMerger {	
	public static List<StoplisInfo> mergeToSelect(List<StoplisInfo> baseInfos, List<StoplisInfo> selectedInfos) {
		InfoMergerBuilderV3<StoplisInfo, StoplisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoplisVisiMergeToSelect());
		InfoMergerV3<StoplisInfo, StoplisInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<StoplisInfo> mergeWithPaypar(List<StoplisInfo> baseInfos, List<PayparInfo> selectedInfos) {
		InfoMergerBuilderV3<StoplisInfo, PayparInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoplisVisiMergePaypar());
		InfoMergerV3<StoplisInfo, PayparInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<StoplisInfo> mergeWithStoparch(List<StoplisInfo> baseInfos, List<StoparchInfo> selectedInfos) {
		InfoMergerBuilderV3<StoplisInfo, StoparchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoplisVisiMergeStoparch());
		InfoMergerV3<StoplisInfo, StoparchInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
