package br.com.mind5.payment.customerPartner.info;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;
import br.com.mind5.security.userList.info.UselisInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class CusparMerger {	
	public static List<CusparInfo> mergeWithPhone(List<CusparInfo> baseInfos, List<PhoneInfo> selectedInfos) {
		InfoMergerBuilderV3<CusparInfo, PhoneInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusparVisiMergePhone());
		InfoMergerV3<CusparInfo, PhoneInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CusparInfo> mergeWithAddress(List<CusparInfo> baseInfos, List<AddressInfo> selectedInfos) {
		InfoMergerBuilderV3<CusparInfo, AddressInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusparVisiMergeAddress());
		InfoMergerV3<CusparInfo, AddressInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CusparInfo> mergeWithCusmoip(List<CusparInfo> baseInfos, List<CusmoipInfo> selectedInfos) {
		InfoMergerBuilderV3<CusparInfo, CusmoipInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusparVisiMergeCusmoip());
		InfoMergerV3<CusparInfo, CusmoipInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CusparInfo> mergeWithUsername(List<CusparInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilderV3<CusparInfo, UsernameInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusparVisiMergeUsername());
		InfoMergerV3<CusparInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CusparInfo> mergeWithUselis(List<CusparInfo> baseInfos, List<UselisInfo> selectedInfos) {
		InfoMergerBuilderV3<CusparInfo, UselisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusparVisiMergeUselis());
		InfoMergerV3<CusparInfo, UselisInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CusparInfo> mergeToSelect(List<CusparInfo> baseInfos, List<CusparInfo> selectedInfos) {
		InfoMergerBuilderV3<CusparInfo, CusparInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusparVisiMergeToSelect());
		InfoMergerV3<CusparInfo, CusparInfo> merger = builder.build();		
	
		return merger.merge();
	}		
}
