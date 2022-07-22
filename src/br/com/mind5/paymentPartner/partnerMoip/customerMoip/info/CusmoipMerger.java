package br.com.mind5.paymentPartner.partnerMoip.customerMoip.info;

import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.masterData.sysEnvironment.info.SysenvInfo;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.security.userSnapshot.info.UserapInfo;

public final class CusmoipMerger {
	
	public static List<CusmoipInfo> mergeWithUserap(List<CusmoipInfo> baseInfos, List<UserapInfo> selectedInfos) {
		InfoMergerBuilder<CusmoipInfo, UserapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusmoipMergerVisiUserap());
		InfoMerger<CusmoipInfo, UserapInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CusmoipInfo> mergeWithSysenv(List<CusmoipInfo> baseInfos, List<SysenvInfo> selectedInfos) {
		InfoMergerBuilder<CusmoipInfo, SysenvInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusmoipMergerVisiSysenv());
		InfoMerger<CusmoipInfo, SysenvInfo> merger = builder.build();		
	
		return merger.merge();
	}		
	
	
	
	public static List<CusmoipInfo> mergeWithSetupar(List<CusmoipInfo> baseInfos, List<SetuparInfo> selectedInfos) {
		InfoMergerBuilder<CusmoipInfo, SetuparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusmoipMergerVisiSetupar());
		InfoMerger<CusmoipInfo, SetuparInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CusmoipInfo> mergeWithAddresnap(List<CusmoipInfo> baseInfos, List<AddresnapInfo> selectedInfos) {
		InfoMergerBuilder<CusmoipInfo, AddresnapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusmoipMergerVisiAddresnap());
		InfoMerger<CusmoipInfo, AddresnapInfo> merger = builder.build();		
	
		return merger.merge();
	}		
	
	
	
	public static List<CusmoipInfo> mergeWithPhonap(List<CusmoipInfo> baseInfos, List<PhonapInfo> selectedInfos) {
		InfoMergerBuilder<CusmoipInfo, PhonapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusmoipMergerVisiPhonap());
		InfoMerger<CusmoipInfo, PhonapInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
