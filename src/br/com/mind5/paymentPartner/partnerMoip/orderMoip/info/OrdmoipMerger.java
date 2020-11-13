package br.com.mind5.paymentPartner.partnerMoip.orderMoip.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.masterData.sysEnvironment.info.SysenvInfo;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderList.info.PayordistInfo;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.payment.storePartner.info.StoparInfo;
import br.com.mind5.payment.systemPartner.info.SysparInfo;

public final class OrdmoipMerger {
	public static List<OrdmoipInfo> mergeWithStopar(List<OrdmoipInfo> baseInfos, List<StoparInfo> selectedInfos) {
		InfoMergerBuilder<OrdmoipInfo, StoparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdmoipVisiMergeStopar());
		InfoMerger<OrdmoipInfo, StoparInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OrdmoipInfo> mergeWithSyspar(List<OrdmoipInfo> baseInfos, List<SysparInfo> selectedInfos) {
		InfoMergerBuilder<OrdmoipInfo, SysparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdmoipVisiMergeSyspar());
		InfoMerger<OrdmoipInfo, SysparInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OrdmoipInfo> mergeWithSysEnviron(List<OrdmoipInfo> baseInfos, List<SysenvInfo> selectedInfos) {
		InfoMergerBuilder<OrdmoipInfo, SysenvInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdmoipVisiMergeSysenv());
		InfoMerger<OrdmoipInfo, SysenvInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OrdmoipInfo> mergeWithSetupar(List<OrdmoipInfo> baseInfos, List<SetuparInfo> selectedInfos) {
		InfoMergerBuilder<OrdmoipInfo, SetuparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdmoipVisiMergeSetupar());
		InfoMerger<OrdmoipInfo, SetuparInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrdmoipInfo> mergeWithPayordist(List<OrdmoipInfo> baseInfos, List<PayordistInfo> selectedInfos) {
		InfoMergerBuilder<OrdmoipInfo, PayordistInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdmoipVisiMergePayordist());
		InfoMerger<OrdmoipInfo, PayordistInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrdmoipInfo> mergeWithPayordem(List<OrdmoipInfo> baseInfos, List<PayordemInfo> selectedInfos) {
		InfoMergerBuilder<OrdmoipInfo, PayordemInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdmoipVisiMergePayordem());
		InfoMerger<OrdmoipInfo, PayordemInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrdmoipInfo> mergeWithCuspar(List<OrdmoipInfo> baseInfos, List<CusparInfo> selectedInfos) {
		InfoMergerBuilder<OrdmoipInfo, CusparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdmoipVisiMergeCuspar());
		InfoMerger<OrdmoipInfo, CusparInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
