package br.com.mind5.paymentPartner.partnerMoip.orderMoip.info;

import java.util.List;

import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderList.info.PayordistInfo;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.payment.storePartner.info.StoparInfo;
import br.com.mind5.payment.systemPartner.info.SysparInfo;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;

public final class OrdmoipMerger {
	public static List<OrdmoipInfo> mergeWithStopar(List<OrdmoipInfo> baseInfos, List<StoparInfo> selectedInfos) {
		InfoMergerBuilderV3<OrdmoipInfo, StoparInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdmoipVisiMergeStopar());
		InfoMergerV3<OrdmoipInfo, StoparInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OrdmoipInfo> mergeWithSyspar(List<OrdmoipInfo> baseInfos, List<SysparInfo> selectedInfos) {
		InfoMergerBuilderV3<OrdmoipInfo, SysparInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdmoipVisiMergeSyspar());
		InfoMergerV3<OrdmoipInfo, SysparInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OrdmoipInfo> mergeWithSysEnviron(List<OrdmoipInfo> baseInfos, List<SysEnvironInfo> selectedInfos) {
		InfoMergerBuilderV3<OrdmoipInfo, SysEnvironInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdmoipVisiMergeSysEnviron());
		InfoMergerV3<OrdmoipInfo, SysEnvironInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OrdmoipInfo> mergeWithSetupar(List<OrdmoipInfo> baseInfos, List<SetuparInfo> selectedInfos) {
		InfoMergerBuilderV3<OrdmoipInfo, SetuparInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdmoipVisiMergeSetupar());
		InfoMergerV3<OrdmoipInfo, SetuparInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrdmoipInfo> mergeWithPayordist(List<OrdmoipInfo> baseInfos, List<PayordistInfo> selectedInfos) {
		InfoMergerBuilderV3<OrdmoipInfo, PayordistInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdmoipVisiMergePayordist());
		InfoMergerV3<OrdmoipInfo, PayordistInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrdmoipInfo> mergeWithPayordem(List<OrdmoipInfo> baseInfos, List<PayordemInfo> selectedInfos) {
		InfoMergerBuilderV3<OrdmoipInfo, PayordemInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdmoipVisiMergePayordem());
		InfoMergerV3<OrdmoipInfo, PayordemInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrdmoipInfo> mergeWithCuspar(List<OrdmoipInfo> baseInfos, List<CusparInfo> selectedInfos) {
		InfoMergerBuilderV3<OrdmoipInfo, CusparInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdmoipVisiMergeCuspar());
		InfoMergerV3<OrdmoipInfo, CusparInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
