package br.com.mind5.payment.payOrderItem.info;

import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.feeCategory.info.FeecatInfo;
import br.com.mind5.payment.marketplacePartner.info.MktparInfo;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;
import br.com.mind5.payment.payOrderList.info.PayordistInfo;
import br.com.mind5.payment.storePartner.info.StoparInfo;

public final class PayordemMerger {
	public static List<PayordemInfo> mergeWithPayormarch(List<PayordemInfo> baseInfos, List<PayormarchInfo> selectedInfos) {
		InfoMergerBuilder<PayordemInfo, PayormarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PayordemMergerVisiPayormarch());
		InfoMerger<PayordemInfo, PayormarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PayordemInfo> mergeWithPayordist(List<PayordemInfo> baseInfos, List<PayordistInfo> selectedInfos) {
		InfoMergerBuilder<PayordemInfo, PayordistInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PayordemMergerVisiPayordist());
		InfoMerger<PayordemInfo, PayordistInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PayordemInfo> mergeWithMktpar(List<PayordemInfo> baseInfos, List<MktparInfo> selectedInfos) {
		InfoMergerBuilder<PayordemInfo, MktparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PayordemMergerVisiMktpar());
		InfoMerger<PayordemInfo, MktparInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PayordemInfo> mergeWithStopar(List<PayordemInfo> baseInfos, List<StoparInfo> selectedInfos) {
		InfoMergerBuilder<PayordemInfo, StoparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PayordemMergerVisiStopar());
		InfoMerger<PayordemInfo, StoparInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PayordemInfo> mergeWithMatlis(List<PayordemInfo> baseInfos, List<MatlisInfo> selectedInfos) {
		InfoMergerBuilder<PayordemInfo, MatlisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PayordemMergerVisiMatlis());
		InfoMerger<PayordemInfo, MatlisInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<PayordemInfo> mergeWithFeecat(List<PayordemInfo> baseInfos, List<FeecatInfo> selectedInfos) {
		InfoMergerBuilder<PayordemInfo, FeecatInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PayordemMergerVisiFeecat());
		InfoMerger<PayordemInfo, FeecatInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<PayordemInfo> mergeToSelect(List<PayordemInfo> baseInfos, List<PayordemInfo> selectedInfos) {
		InfoMergerBuilder<PayordemInfo, PayordemInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PayordemMergerVisiToSelect());
		InfoMerger<PayordemInfo, PayordemInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<PayordemInfo> mergeToUpdate(List<PayordemInfo> baseInfos, List<PayordemInfo> selectedInfos) {
		InfoMergerBuilder<PayordemInfo, PayordemInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PayordemMergerVisiToUpdate());
		InfoMerger<PayordemInfo, PayordemInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<PayordemInfo> mergeToUpdateStatus(List<PayordemInfo> baseInfos, List<PayordemInfo> selectedInfos) {
		InfoMergerBuilder<PayordemInfo, PayordemInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PayordemMergerVisiToUpdateStatus());
		InfoMerger<PayordemInfo, PayordemInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
