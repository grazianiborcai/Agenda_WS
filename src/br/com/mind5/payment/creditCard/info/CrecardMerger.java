package br.com.mind5.payment.creditCard.info;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.payment.creditCardSearch.info.CrecarchInfo;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchInfo;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class CrecardMerger {
	public static List<CrecardInfo> mergeWithCusparch(List<CrecardInfo> baseInfos, List<CusparchInfo> selectedInfos) {
		InfoMergerBuilder<CrecardInfo, CusparchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CrecardVisiMergeCusparch());
		InfoMerger<CrecardInfo, CusparchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CrecardInfo> mergeWithCrecarch(List<CrecardInfo> baseInfos, List<CrecarchInfo> selectedInfos) {
		InfoMergerBuilder<CrecardInfo, CrecarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CrecardVisiMergeCrecarch());
		InfoMerger<CrecardInfo, CrecarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CrecardInfo> mergeWithCremoip(List<CrecardInfo> baseInfos, List<CremoipInfo> selectedInfos) {
		InfoMergerBuilder<CrecardInfo, CremoipInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CrecardVisiMergeCremoip());
		InfoMerger<CrecardInfo, CremoipInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CrecardInfo> mergeWithPhone(List<CrecardInfo> baseInfos, List<PhoneInfo> selectedInfos) {
		InfoMergerBuilder<CrecardInfo, PhoneInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CrecardVisiMergePhone());
		InfoMerger<CrecardInfo, PhoneInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	public static List<CrecardInfo> mergeWithAddress(List<CrecardInfo> baseInfos, List<AddressInfo> selectedInfos) {
		InfoMergerBuilder<CrecardInfo, AddressInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CrecardVisiMergeAddress());
		InfoMerger<CrecardInfo, AddressInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CrecardInfo> mergeWithCuspar(List<CrecardInfo> baseInfos, List<CusparInfo> selectedInfos) {
		InfoMergerBuilder<CrecardInfo, CusparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CrecardVisiMergeCuspar());
		InfoMerger<CrecardInfo, CusparInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CrecardInfo> mergeWithCusparInsert(List<CrecardInfo> baseInfos, List<CusparInfo> selectedInfos) {
		InfoMergerBuilder<CrecardInfo, CusparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CrecardVisiMergeCusparInsert());
		InfoMerger<CrecardInfo, CusparInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CrecardInfo> mergeWithUsername(List<CrecardInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<CrecardInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CrecardVisiMergeUsername());
		InfoMerger<CrecardInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CrecardInfo> mergeToSelect(List<CrecardInfo> baseInfos, List<CrecardInfo> selectedInfos) {
		InfoMergerBuilder<CrecardInfo, CrecardInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CrecardVisiMergeToSelect());
		InfoMerger<CrecardInfo, CrecardInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CrecardInfo> mergeToDelete(List<CrecardInfo> baseInfos, List<CrecardInfo> selectedInfos) {
		InfoMergerBuilder<CrecardInfo, CrecardInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CrecardVisiMergeToDelete());
		InfoMerger<CrecardInfo, CrecardInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
