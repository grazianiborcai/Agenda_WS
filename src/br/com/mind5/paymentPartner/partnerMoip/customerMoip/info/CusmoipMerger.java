package br.com.mind5.paymentPartner.partnerMoip.customerMoip.info;

import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.security.userSnapshot.info.UserapInfo;

public final class CusmoipMerger {
	
	public static List<CusmoipInfo> mergeWithUserap(List<CusmoipInfo> baseInfos, List<UserapInfo> selectedInfos) {
		InfoMergerBuilderV3<CusmoipInfo, UserapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusmoipVisiMergeUserap());
		InfoMergerV3<CusmoipInfo, UserapInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CusmoipInfo> mergeWithSysEnviron(List<CusmoipInfo> baseInfos, List<SysEnvironInfo> selectedInfos) {
		InfoMergerBuilderV3<CusmoipInfo, SysEnvironInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusmoipVisiMergeSysEnviron());
		InfoMergerV3<CusmoipInfo, SysEnvironInfo> merger = builder.build();		
	
		return merger.merge();
	}		
	
	
	
	public static List<CusmoipInfo> mergeWithSetupar(List<CusmoipInfo> baseInfos, List<SetuparInfo> selectedInfos) {
		InfoMergerBuilderV3<CusmoipInfo, SetuparInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusmoipVisiMergeSetupar());
		InfoMergerV3<CusmoipInfo, SetuparInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CusmoipInfo> mergeWithAddresnap(List<CusmoipInfo> baseInfos, List<AddresnapInfo> selectedInfos) {
		InfoMergerBuilderV3<CusmoipInfo, AddresnapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusmoipVisiMergeAddresnap());
		InfoMergerV3<CusmoipInfo, AddresnapInfo> merger = builder.build();		
	
		return merger.merge();
	}		
	
	
	
	public static List<CusmoipInfo> mergeWithPhonap(List<CusmoipInfo> baseInfos, List<PhonapInfo> selectedInfos) {
		InfoMergerBuilderV3<CusmoipInfo, PhonapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusmoipVisiMergePhonap());
		InfoMergerV3<CusmoipInfo, PhonapInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
