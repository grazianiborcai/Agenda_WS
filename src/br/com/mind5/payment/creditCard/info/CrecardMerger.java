package br.com.mind5.payment.creditCard.info;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class CrecardMerger {
	public static List<CrecardInfo> mergeWithCremoip(List<CrecardInfo> baseInfos, List<CremoipInfo> selectedInfos) {
		InfoMergerBuilderV3<CrecardInfo, CremoipInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CrecardVisiMergeCremoip());
		InfoMergerV3<CrecardInfo, CremoipInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CrecardInfo> mergeWithPhone(List<CrecardInfo> baseInfos, List<PhoneInfo> selectedInfos) {
		InfoMergerBuilderV3<CrecardInfo, PhoneInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CrecardVisiMergePhone());
		InfoMergerV3<CrecardInfo, PhoneInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	public static List<CrecardInfo> mergeWithAddress(List<CrecardInfo> baseInfos, List<AddressInfo> selectedInfos) {
		InfoMergerBuilderV3<CrecardInfo, AddressInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CrecardVisiMergeAddress());
		InfoMergerV3<CrecardInfo, AddressInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CrecardInfo> mergeWithCuspar(List<CrecardInfo> baseInfos, List<CusparInfo> selectedInfos) {
		InfoMergerBuilderV3<CrecardInfo, CusparInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CrecardVisiMergeCuspar());
		InfoMergerV3<CrecardInfo, CusparInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CrecardInfo> mergeWithUsername(List<CrecardInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilderV3<CrecardInfo, UsernameInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CrecardVisiMergeUsername());
		InfoMergerV3<CrecardInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CrecardInfo> mergeToSelect(List<CrecardInfo> baseInfos, List<CrecardInfo> selectedInfos) {
		InfoMergerBuilderV3<CrecardInfo, CrecardInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CrecardVisiMergeToSelect());
		InfoMergerV3<CrecardInfo, CrecardInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CrecardInfo> mergeToDelete(List<CrecardInfo> baseInfos, List<CrecardInfo> selectedInfos) {
		InfoMergerBuilderV3<CrecardInfo, CrecardInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CrecardVisiMergeToDelete());
		InfoMergerV3<CrecardInfo, CrecardInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CrecardInfo> mergeToUpdate(List<CrecardInfo> baseInfos, List<CrecardInfo> selectedInfos) {
		InfoMergerBuilderV3<CrecardInfo, CrecardInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CrecardVisiMergeToUpdate());
		InfoMergerV3<CrecardInfo, CrecardInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
