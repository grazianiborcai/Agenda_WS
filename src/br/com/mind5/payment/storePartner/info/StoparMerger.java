package br.com.mind5.payment.storePartner.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.paymentPartner.info.PayparInfo;
import br.com.mind5.payment.storePartnerSnapshot.info.StoparnapInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class StoparMerger {
	public static List<StoparInfo> mergeWithPaypar(List<StoparInfo> baseInfos, List<PayparInfo> selectedInfos) {
		InfoMergerBuilder<StoparInfo, PayparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoparMergerVisiPaypar());
		InfoMerger<StoparInfo, PayparInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoparInfo> mergeWithStoparnap(List<StoparInfo> baseInfos, List<StoparnapInfo> selectedInfos) {
		InfoMergerBuilder<StoparInfo, StoparnapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoparMergerVisiStoparnap());
		InfoMerger<StoparInfo, StoparnapInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<StoparInfo> mergeWithUsername(List<StoparInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<StoparInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoparMergerVisiUsername());
		InfoMerger<StoparInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	
	public static List<StoparInfo> mergeToSelect(List<StoparInfo> baseInfos, List<StoparInfo> selectedInfos) {
		InfoMergerBuilder<StoparInfo, StoparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoparMergerVisiToSelect());
		InfoMerger<StoparInfo, StoparInfo> merger = builder.build();		
	
		return merger.merge();
	}		
	
	
	
	public static List<StoparInfo> mergeToDelete(List<StoparInfo> baseInfos, List<StoparInfo> selectedInfos) {
		InfoMergerBuilder<StoparInfo, StoparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoparMergerVisiToDelete());
		InfoMerger<StoparInfo, StoparInfo> merger = builder.build();		
	
		return merger.merge();
	}			
}
