package br.com.mind5.payment.storePartnerList.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.masterData.paymentPartner.info.PayparInfo;
import br.com.mind5.payment.storePartnerSearch.info.StoparchInfo;

public final class StoplisMerger {	
	public static List<StoplisInfo> mergeToSelect(List<StoplisInfo> baseInfos, List<StoplisInfo> selectedInfos) {
		InfoMergerBuilder<StoplisInfo, StoplisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoplisMergerVisiToSelect());
		InfoMerger<StoplisInfo, StoplisInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<StoplisInfo> mergeWithPaypar(List<StoplisInfo> baseInfos, List<PayparInfo> selectedInfos) {
		InfoMergerBuilder<StoplisInfo, PayparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoplisMergerVisiPaypar());
		InfoMerger<StoplisInfo, PayparInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<StoplisInfo> mergeWithStoparch(List<StoplisInfo> baseInfos, List<StoparchInfo> selectedInfos) {
		InfoMergerBuilder<StoplisInfo, StoparchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoplisMergerVisiStoparch());
		InfoMerger<StoplisInfo, StoparchInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
