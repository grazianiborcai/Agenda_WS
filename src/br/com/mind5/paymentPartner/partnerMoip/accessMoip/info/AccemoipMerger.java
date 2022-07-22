package br.com.mind5.paymentPartner.partnerMoip.accessMoip.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.masterData.sysEnvironment.info.SysenvInfo;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.payment.systemPartner.info.SysparInfo;

public final class AccemoipMerger {
	public static List<AccemoipInfo> mergeWithSysenv(List<AccemoipInfo> baseInfos, List<SysenvInfo> selectedInfos) {
		InfoMergerBuilder<AccemoipInfo, SysenvInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AccemoipMergerVisiSysenv());
		InfoMerger<AccemoipInfo, SysenvInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<AccemoipInfo> mergeWithSetupar(List<AccemoipInfo> baseInfos, List<SetuparInfo> selectedInfos) {
		InfoMergerBuilder<AccemoipInfo, SetuparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AccemoipMergerVisiSetupar());
		InfoMerger<AccemoipInfo, SetuparInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<AccemoipInfo> mergeWithSyspar(List<AccemoipInfo> baseInfos, List<SysparInfo> selectedInfos) {
		InfoMergerBuilder<AccemoipInfo, SysparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AccemoipMergerVisiSyspar());
		InfoMerger<AccemoipInfo, SysparInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
