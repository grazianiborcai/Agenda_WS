package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info;

import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.sysEnvironment.info.SysenvInfo;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

public final class CremoipMerger {
	public static List<CremoipInfo> mergeWithCuspar(List<CremoipInfo> baseInfos, List<CusparInfo> selectedInfos) {
		InfoMergerBuilderV3<CremoipInfo, CusparInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CremoipVisiMergeCuspar());
		InfoMergerV3<CremoipInfo, CusparInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CremoipInfo> mergeWithSysenv(List<CremoipInfo> baseInfos, List<SysenvInfo> selectedInfos) {
		InfoMergerBuilderV3<CremoipInfo, SysenvInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CremoipVisiMergeSysenv());
		InfoMergerV3<CremoipInfo, SysenvInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CremoipInfo> mergeWithSetupar(List<CremoipInfo> baseInfos, List<SetuparInfo> selectedInfos) {
		InfoMergerBuilderV3<CremoipInfo, SetuparInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CremoipVisiMergeSetupar());
		InfoMergerV3<CremoipInfo, SetuparInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CremoipInfo> mergeWithAddresnap(List<CremoipInfo> baseInfos, List<AddresnapInfo> selectedInfos) {
		InfoMergerBuilderV3<CremoipInfo, AddresnapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CremoipVisiMergeAddresnap());
		InfoMergerV3<CremoipInfo, AddresnapInfo> merger = builder.build();		
	
		return merger.merge();
	}		
	
	
	
	public static List<CremoipInfo> mergeWithPhonap(List<CremoipInfo> baseInfos, List<PhonapInfo> selectedInfos) {
		InfoMergerBuilderV3<CremoipInfo, PhonapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CremoipVisiMergePhonap());
		InfoMergerV3<CremoipInfo, PhonapInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
