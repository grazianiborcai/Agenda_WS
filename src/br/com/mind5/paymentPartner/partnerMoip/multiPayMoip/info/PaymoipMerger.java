package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.masterData.sysEnvironment.info.SysenvInfo;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.payment.systemPartner.info.SysparInfo;

public final class PaymoipMerger {
	public static List<PaymoipInfo> mergeWithSyspar(List<PaymoipInfo> baseInfos, List<SysparInfo> selectedInfos) {
		InfoMergerBuilder<PaymoipInfo, SysparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PaymoipMergerVisiSyspar());
		InfoMerger<PaymoipInfo, SysparInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<PaymoipInfo> mergeWithCrecard(List<PaymoipInfo> baseInfos, List<CrecardInfo> selectedInfos) {
		InfoMergerBuilder<PaymoipInfo, CrecardInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PaymoipMergerVisiCrecard());
		InfoMerger<PaymoipInfo, CrecardInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<PaymoipInfo> mergeWithSetupar(List<PaymoipInfo> baseInfos, List<SetuparInfo> selectedInfos) {
		InfoMergerBuilder<PaymoipInfo, SetuparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PaymoipMergerVisiSetupar());
		InfoMerger<PaymoipInfo, SetuparInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<PaymoipInfo> mergeWithSysenv(List<PaymoipInfo> baseInfos, List<SysenvInfo> selectedInfos) {
		InfoMergerBuilder<PaymoipInfo, SysenvInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PaymoipMergerVisiSysenv());
		InfoMerger<PaymoipInfo, SysenvInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
