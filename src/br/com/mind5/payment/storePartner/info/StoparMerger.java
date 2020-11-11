package br.com.mind5.payment.storePartner.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.paymentPartner.info.PayparInfo;
import br.com.mind5.payment.storePartnerSearch.info.StoparchInfo;
import br.com.mind5.payment.storePartnerSnapshot.info.StoparnapInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class StoparMerger {	
	public static List<StoparInfo> mergeWithStoparch(List<StoparInfo> baseInfos, List<StoparchInfo> selectedInfos) {
		InfoMergerBuilderV3<StoparInfo, StoparchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoparVisiMergeStoparch());
		InfoMergerV3<StoparInfo, StoparchInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<StoparInfo> mergeWithPaypar(List<StoparInfo> baseInfos, List<PayparInfo> selectedInfos) {
		InfoMergerBuilderV3<StoparInfo, PayparInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoparVisiMergePaypar());
		InfoMergerV3<StoparInfo, PayparInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoparInfo> mergeWithStoparnap(List<StoparInfo> baseInfos, List<StoparnapInfo> selectedInfos) {
		InfoMergerBuilderV3<StoparInfo, StoparnapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoparVisiMergeStoparnap());
		InfoMergerV3<StoparInfo, StoparnapInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<StoparInfo> mergeWithUsername(List<StoparInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilderV3<StoparInfo, UsernameInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoparVisiMergeUsername());
		InfoMergerV3<StoparInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	
	public static List<StoparInfo> mergeToSelect(List<StoparInfo> baseInfos, List<StoparInfo> selectedInfos) {
		InfoMergerBuilderV3<StoparInfo, StoparInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoparVisiMergeToSelect());
		InfoMergerV3<StoparInfo, StoparInfo> merger = builder.build();		
	
		return merger.merge();
	}		
	
	
	
	public static List<StoparInfo> mergeToDelete(List<StoparInfo> baseInfos, List<StoparInfo> selectedInfos) {
		InfoMergerBuilderV3<StoparInfo, StoparInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoparVisiMergeToDelete());
		InfoMergerV3<StoparInfo, StoparInfo> merger = builder.build();		
	
		return merger.merge();
	}			
}
