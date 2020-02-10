package br.com.mind5.paymentPartner.partnerMoip.customerMoip.info;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.security.userList.info.UselisInfo;

public final class CusmoipMerger {
	
	public static List<CusmoipInfo> mergeWithUselis(List<CusmoipInfo> baseInfos, List<UselisInfo> selectedInfos) {
		InfoMergerBuilderV3<CusmoipInfo, UselisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusmoipVisiMergeUselis());
		InfoMergerV3<CusmoipInfo, UselisInfo> merger = builder.build();		
	
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
	
	
	
	public static List<CusmoipInfo> mergeWithAddress(List<CusmoipInfo> baseInfos, List<AddressInfo> selectedInfos) {
		InfoMergerBuilderV3<CusmoipInfo, AddressInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusmoipVisiMergeAddress());
		InfoMergerV3<CusmoipInfo, AddressInfo> merger = builder.build();		
	
		return merger.merge();
	}		
	
	
	
	public static List<CusmoipInfo> mergeWithPhone(List<CusmoipInfo> baseInfos, List<PhoneInfo> selectedInfos) {
		InfoMergerBuilderV3<CusmoipInfo, PhoneInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusmoipVisiMergePhone());
		InfoMergerV3<CusmoipInfo, PhoneInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
