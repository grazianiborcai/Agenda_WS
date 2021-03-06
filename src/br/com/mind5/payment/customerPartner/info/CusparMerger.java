package br.com.mind5.payment.customerPartner.info;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchInfo;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;
import br.com.mind5.security.userList.info.UselisInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class CusparMerger {	
	public static List<CusparInfo> mergeWithPhone(List<CusparInfo> baseInfos, List<PhoneInfo> selectedInfos) {
		InfoMergerBuilder<CusparInfo, PhoneInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusparVisiMergePhone());
		InfoMerger<CusparInfo, PhoneInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CusparInfo> mergeWithCusparch(List<CusparInfo> baseInfos, List<CusparchInfo> selectedInfos) {
		InfoMergerBuilder<CusparInfo, CusparchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusparVisiMergeCusparch());
		InfoMerger<CusparInfo, CusparchInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CusparInfo> mergeWithAddress(List<CusparInfo> baseInfos, List<AddressInfo> selectedInfos) {
		InfoMergerBuilder<CusparInfo, AddressInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusparVisiMergeAddress());
		InfoMerger<CusparInfo, AddressInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CusparInfo> mergeWithCusmoip(List<CusparInfo> baseInfos, List<CusmoipInfo> selectedInfos) {
		InfoMergerBuilder<CusparInfo, CusmoipInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusparVisiMergeCusmoip());
		InfoMerger<CusparInfo, CusmoipInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CusparInfo> mergeWithUsername(List<CusparInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<CusparInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusparVisiMergeUsername());
		InfoMerger<CusparInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CusparInfo> mergeWithUselis(List<CusparInfo> baseInfos, List<UselisInfo> selectedInfos) {
		InfoMergerBuilder<CusparInfo, UselisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusparVisiMergeUselis());
		InfoMerger<CusparInfo, UselisInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CusparInfo> mergeToSelect(List<CusparInfo> baseInfos, List<CusparInfo> selectedInfos) {
		InfoMergerBuilder<CusparInfo, CusparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusparVisiMergeToSelect());
		InfoMerger<CusparInfo, CusparInfo> merger = builder.build();		
	
		return merger.merge();
	}		
}
