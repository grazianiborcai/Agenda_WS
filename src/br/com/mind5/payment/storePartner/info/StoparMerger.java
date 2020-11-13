package br.com.mind5.payment.storePartner.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.masterData.paymentPartner.info.PayparInfo;
import br.com.mind5.payment.storePartnerSearch.info.StoparchInfo;
import br.com.mind5.payment.storePartnerSnapshot.info.StoparnapInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class StoparMerger {	
	public static List<StoparInfo> mergeWithStoparch(List<StoparInfo> baseInfos, List<StoparchInfo> selectedInfos) {
		InfoMergerBuilder<StoparInfo, StoparchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoparVisiMergeStoparch());
		InfoMerger<StoparInfo, StoparchInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<StoparInfo> mergeWithPaypar(List<StoparInfo> baseInfos, List<PayparInfo> selectedInfos) {
		InfoMergerBuilder<StoparInfo, PayparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoparVisiMergePaypar());
		InfoMerger<StoparInfo, PayparInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoparInfo> mergeWithStoparnap(List<StoparInfo> baseInfos, List<StoparnapInfo> selectedInfos) {
		InfoMergerBuilder<StoparInfo, StoparnapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoparVisiMergeStoparnap());
		InfoMerger<StoparInfo, StoparnapInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<StoparInfo> mergeWithUsername(List<StoparInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<StoparInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoparVisiMergeUsername());
		InfoMerger<StoparInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	
	public static List<StoparInfo> mergeToSelect(List<StoparInfo> baseInfos, List<StoparInfo> selectedInfos) {
		InfoMergerBuilder<StoparInfo, StoparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoparVisiMergeToSelect());
		InfoMerger<StoparInfo, StoparInfo> merger = builder.build();		
	
		return merger.merge();
	}		
	
	
	
	public static List<StoparInfo> mergeToDelete(List<StoparInfo> baseInfos, List<StoparInfo> selectedInfos) {
		InfoMergerBuilder<StoparInfo, StoparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoparVisiMergeToDelete());
		InfoMerger<StoparInfo, StoparInfo> merger = builder.build();		
	
		return merger.merge();
	}			
}
