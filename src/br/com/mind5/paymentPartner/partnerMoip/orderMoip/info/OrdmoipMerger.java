package br.com.mind5.paymentPartner.partnerMoip.orderMoip.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.masterData.sysEnvironment.info.SysenvInfo;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.marketplacePartner.info.MktparInfo;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderList.info.PayordistInfo;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.payment.storePartner.info.StoparInfo;

public final class OrdmoipMerger {
	public static List<OrdmoipInfo> mergeWithStopar(List<OrdmoipInfo> baseInfos, List<StoparInfo> selectedInfos) {
		InfoMergerBuilder<OrdmoipInfo, StoparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdmoipMergerVisiStopar());
		InfoMerger<OrdmoipInfo, StoparInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OrdmoipInfo> mergeWithSyspar(List<OrdmoipInfo> baseInfos, List<MktparInfo> selectedInfos) {
		InfoMergerBuilder<OrdmoipInfo, MktparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdmoipMergerVisiSyspar());
		InfoMerger<OrdmoipInfo, MktparInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OrdmoipInfo> mergeWithSysEnviron(List<OrdmoipInfo> baseInfos, List<SysenvInfo> selectedInfos) {
		InfoMergerBuilder<OrdmoipInfo, SysenvInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdmoipMergerVisiSysenv());
		InfoMerger<OrdmoipInfo, SysenvInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OrdmoipInfo> mergeWithSetupar(List<OrdmoipInfo> baseInfos, List<SetuparInfo> selectedInfos) {
		InfoMergerBuilder<OrdmoipInfo, SetuparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdmoipMergerVisiSetupar());
		InfoMerger<OrdmoipInfo, SetuparInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrdmoipInfo> mergeWithPayordist(List<OrdmoipInfo> baseInfos, List<PayordistInfo> selectedInfos) {
		InfoMergerBuilder<OrdmoipInfo, PayordistInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdmoipMergerVisiPayordist());
		InfoMerger<OrdmoipInfo, PayordistInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrdmoipInfo> mergeWithPayordem(List<OrdmoipInfo> baseInfos, List<PayordemInfo> selectedInfos) {
		InfoMergerBuilder<OrdmoipInfo, PayordemInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdmoipMergerVisiPayordem());
		InfoMerger<OrdmoipInfo, PayordemInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrdmoipInfo> mergeWithCuspar(List<OrdmoipInfo> baseInfos, List<CusparInfo> selectedInfos) {
		InfoMergerBuilder<OrdmoipInfo, CusparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdmoipMergerVisiCuspar());
		InfoMerger<OrdmoipInfo, CusparInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
