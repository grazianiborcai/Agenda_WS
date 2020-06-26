package br.com.mind5.business.storeSnapshot.info;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.business.companySnapshot.info.CompnapInfo;
import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.currency.info.CurrencyInfo;
import br.com.mind5.masterData.timezone.info.TimezoneInfo;
import br.com.mind5.security.userList.info.UselisInfo;
import br.com.mind5.security.userSnapshot.info.UserapInfo;

public final class StorapMerger {
	public static List<StorapInfo> mergeWithAddress(List<StorapInfo> baseInfos, List<AddressInfo> selectedInfos) {
		InfoMergerBuilderV3<StorapInfo, AddressInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorapVisiMergeAddress());
		InfoMergerV3<StorapInfo, AddressInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorapInfo> mergeWithAddresnap(List<StorapInfo> baseInfos, List<AddresnapInfo> selectedInfos) {
		InfoMergerBuilderV3<StorapInfo, AddresnapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorapVisiMergeAddresnap());
		InfoMergerV3<StorapInfo, AddresnapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorapInfo> mergeWithComplis(List<StorapInfo> baseInfos, List<ComplisInfo> selectedInfos) {
		InfoMergerBuilderV3<StorapInfo, ComplisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorapVisiMergeComplis());
		InfoMergerV3<StorapInfo, ComplisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorapInfo> mergeWithCompnap(List<StorapInfo> baseInfos, List<CompnapInfo> selectedInfos) {
		InfoMergerBuilderV3<StorapInfo, CompnapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorapVisiMergeCompnap());
		InfoMergerV3<StorapInfo, CompnapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorapInfo> mergeWithCurrency(List<StorapInfo> baseInfos, List<CurrencyInfo> selectedInfos) {
		InfoMergerBuilderV3<StorapInfo, CurrencyInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorapVisiMergeCurrency());
		InfoMergerV3<StorapInfo, CurrencyInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorapInfo> mergeWithPersolis(List<StorapInfo> baseInfos, List<PersolisInfo> selectedInfos) {
		InfoMergerBuilderV3<StorapInfo, PersolisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorapVisiMergePersolis());
		InfoMergerV3<StorapInfo, PersolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorapInfo> mergeWithPersonap(List<StorapInfo> baseInfos, List<PersonapInfo> selectedInfos) {
		InfoMergerBuilderV3<StorapInfo, PersonapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorapVisiMergePersonap());
		InfoMergerV3<StorapInfo, PersonapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorapInfo> mergeWithPhonap(List<StorapInfo> baseInfos, List<PhonapInfo> selectedInfos) {
		InfoMergerBuilderV3<StorapInfo, PhonapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorapVisiMergePhonap());
		InfoMergerV3<StorapInfo, PhonapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorapInfo> mergeWithTimezone(List<StorapInfo> baseInfos, List<TimezoneInfo> selectedInfos) {
		InfoMergerBuilderV3<StorapInfo, TimezoneInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorapVisiMergeTimezone());
		InfoMergerV3<StorapInfo, TimezoneInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorapInfo> mergeWithUselis(List<StorapInfo> baseInfos, List<UselisInfo> selectedInfos) {
		InfoMergerBuilderV3<StorapInfo, UselisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorapVisiMergeUselis());
		InfoMergerV3<StorapInfo, UselisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorapInfo> mergeWithUserap(List<StorapInfo> baseInfos, List<UserapInfo> selectedInfos) {
		InfoMergerBuilderV3<StorapInfo, UserapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorapVisiMergeUserap());
		InfoMergerV3<StorapInfo, UserapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorapInfo> mergeToSelect(List<StorapInfo> baseInfos, List<StorapInfo> selectedInfos) {
		InfoMergerBuilderV3<StorapInfo, StorapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorapVisiMergeToSelect());
		InfoMergerV3<StorapInfo, StorapInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
