package br.com.mind5.payment.payOrderItem.info;

import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.feeCategory.info.FeecatInfo;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;

public final class PayordemMerger {
	public static List<PayordemInfo> mergeWithPayormarch(List<PayordemInfo> baseInfos, List<PayormarchInfo> selectedInfos) {
		InfoMergerBuilderV3<PayordemInfo, PayormarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PayordemVisiMergePayormarch());
		InfoMergerV3<PayordemInfo, PayormarchInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<PayordemInfo> mergeWithMatlis(List<PayordemInfo> baseInfos, List<MatlisInfo> selectedInfos) {
		InfoMergerBuilderV3<PayordemInfo, MatlisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PayordemVisiMergeMatlis());
		InfoMergerV3<PayordemInfo, MatlisInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<PayordemInfo> mergeWithFeecat(List<PayordemInfo> baseInfos, List<FeecatInfo> selectedInfos) {
		InfoMergerBuilderV3<PayordemInfo, FeecatInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PayordemVisiMergeFeecat());
		InfoMergerV3<PayordemInfo, FeecatInfo> merger = builder.build();		
	
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
