package br.com.mind5.payment.customerPartner.info;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phoneDefault.info.PhonaultInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.paymentPartnerDefault.info.PayparultInfo;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchInfo;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;
import br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.info.CustopaInfo;
import br.com.mind5.security.userList.info.UselisInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class CusparMerger {	
	public static List<CusparInfo> mergeWithCuslis(List<CusparInfo> baseInfos, List<CuslisInfo> selectedInfos) {
		InfoMergerBuilder<CusparInfo, CuslisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusparMergerVisiCuslis());
		InfoMerger<CusparInfo, CuslisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CusparInfo> mergeWithPhonault(List<CusparInfo> baseInfos, List<PhonaultInfo> selectedInfos) {
		InfoMergerBuilder<CusparInfo, PhonaultInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusparMergerVisiPhonault());
		InfoMerger<CusparInfo, PhonaultInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CusparInfo> mergeWithCustopa(List<CusparInfo> baseInfos, List<CustopaInfo> selectedInfos) {
		InfoMergerBuilder<CusparInfo, CustopaInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusparMergerVisiCustopa());
		InfoMerger<CusparInfo, CustopaInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CusparInfo> mergeWithPayparult(List<CusparInfo> baseInfos, List<PayparultInfo> selectedInfos) {
		InfoMergerBuilder<CusparInfo, PayparultInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusparMergerVisiPayparult());
		InfoMerger<CusparInfo, PayparultInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CusparInfo> mergeWithPhone(List<CusparInfo> baseInfos, List<PhoneInfo> selectedInfos) {
		InfoMergerBuilder<CusparInfo, PhoneInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusparMergerVisiPhone());
		InfoMerger<CusparInfo, PhoneInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CusparInfo> mergeWithCusparch(List<CusparInfo> baseInfos, List<CusparchInfo> selectedInfos) {
		InfoMergerBuilder<CusparInfo, CusparchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusparMergerVisiCusparch());
		InfoMerger<CusparInfo, CusparchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CusparInfo> mergeWithAddress(List<CusparInfo> baseInfos, List<AddressInfo> selectedInfos) {
		InfoMergerBuilder<CusparInfo, AddressInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusparMergerVisiAddress());
		InfoMerger<CusparInfo, AddressInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CusparInfo> mergeWithCusmoip(List<CusparInfo> baseInfos, List<CusmoipInfo> selectedInfos) {
		InfoMergerBuilder<CusparInfo, CusmoipInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusparMergerVisiCusmoip());
		InfoMerger<CusparInfo, CusmoipInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CusparInfo> mergeWithUsername(List<CusparInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<CusparInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusparMergerVisiUsername());
		InfoMerger<CusparInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CusparInfo> mergeWithUselis(List<CusparInfo> baseInfos, List<UselisInfo> selectedInfos) {
		InfoMergerBuilder<CusparInfo, UselisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusparMergerVisiUselis());
		InfoMerger<CusparInfo, UselisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CusparInfo> mergeToSelect(List<CusparInfo> baseInfos, List<CusparInfo> selectedInfos) {
		InfoMergerBuilder<CusparInfo, CusparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusparMergerVisiToSelect());
		InfoMerger<CusparInfo, CusparInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CusparInfo> mergeToUpdate(List<CusparInfo> baseInfos, List<CusparInfo> selectedInfos) {
		InfoMergerBuilder<CusparInfo, CusparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusparMergerVisiToUpdate());
		InfoMerger<CusparInfo, CusparInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
