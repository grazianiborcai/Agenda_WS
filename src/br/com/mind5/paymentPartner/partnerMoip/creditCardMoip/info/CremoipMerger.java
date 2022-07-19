package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info;

import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.masterData.sysEnvironment.info.SysenvInfo;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

public final class CremoipMerger {
	public static List<CremoipInfo> mergeWithCuspar(List<CremoipInfo> baseInfos, List<CusparInfo> selectedInfos) {
		InfoMergerBuilder<CremoipInfo, CusparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CremoipMergerVisiCuspar());
		InfoMerger<CremoipInfo, CusparInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CremoipInfo> mergeWithSysenv(List<CremoipInfo> baseInfos, List<SysenvInfo> selectedInfos) {
		InfoMergerBuilder<CremoipInfo, SysenvInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CremoipMergerVisiSysenv());
		InfoMerger<CremoipInfo, SysenvInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CremoipInfo> mergeWithSetupar(List<CremoipInfo> baseInfos, List<SetuparInfo> selectedInfos) {
		InfoMergerBuilder<CremoipInfo, SetuparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CremoipMergerVisiSetupar());
		InfoMerger<CremoipInfo, SetuparInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CremoipInfo> mergeWithAddresnap(List<CremoipInfo> baseInfos, List<AddresnapInfo> selectedInfos) {
		InfoMergerBuilder<CremoipInfo, AddresnapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CremoipMergerVisiAddresnap());
		InfoMerger<CremoipInfo, AddresnapInfo> merger = builder.build();		
	
		return merger.merge();
	}		
	
	
	
	public static List<CremoipInfo> mergeWithPhonap(List<CremoipInfo> baseInfos, List<PhonapInfo> selectedInfos) {
		InfoMergerBuilder<CremoipInfo, PhonapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CremoipMergerVisiPhonap());
		InfoMerger<CremoipInfo, PhonapInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
