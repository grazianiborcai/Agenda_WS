package br.com.mind5.payment.payOrderItem.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.payment.storePartner.info.StoparInfo;

public final class PayordemMerger {
	public static List<PayordemInfo> mergeWithStopar(List<PayordemInfo> baseInfos, List<StoparInfo> selectedInfos) {
		InfoMergerBuilderV3<PayordemInfo, StoparInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PayordemVisiMergeStopar());
		InfoMergerV3<PayordemInfo, StoparInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<PayordemInfo> mergeToSelect(List<PayordemInfo> baseInfos, List<PayordemInfo> selectedInfos) {
		InfoMergerBuilderV3<PayordemInfo, PayordemInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PayordemVisiMergeToSelect());
		InfoMergerV3<PayordemInfo, PayordemInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<PayordemInfo> mergeToUpdate(List<PayordemInfo> baseInfos, List<PayordemInfo> selectedInfos) {
		InfoMergerBuilderV3<PayordemInfo, PayordemInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PayordemVisiMergeToUpdate());
		InfoMergerV3<PayordemInfo, PayordemInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<PayordemInfo> mergeToUpdateStatus(List<PayordemInfo> baseInfos, List<PayordemInfo> selectedInfos) {
		InfoMergerBuilderV3<PayordemInfo, PayordemInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PayordemVisiMergeToUpdateStatus());
		InfoMergerV3<PayordemInfo, PayordemInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
