package br.com.mind5.business.store.info;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.masterData.info.CurrencyInfo;
import br.com.mind5.business.masterData.info.TimezoneInfo;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class StoreMerger {
	public static List<StoreInfo> mergeWithFimist(List<StoreInfo> baseInfos, List<FimistInfo> selectedInfos) {
		InfoMergerBuilderV3<StoreInfo, FimistInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreVisiMergeFimist());
		InfoMergerV3<StoreInfo, FimistInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoreInfo> mergeWithSotarch(List<StoreInfo> baseInfos, List<SotarchInfo> selectedInfos) {
		InfoMergerBuilderV3<StoreInfo, SotarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreVisiMergeSotarch());
		InfoMergerV3<StoreInfo, SotarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoreInfo> mergeWithAddress(List<StoreInfo> baseInfos, List<AddressInfo> selectedInfos) {
		InfoMergerBuilderV3<StoreInfo, AddressInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreVisiMergeAddress());
		InfoMergerV3<StoreInfo, AddressInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoreInfo> mergeWithStorap(List<StoreInfo> baseInfos, List<StorapInfo> selectedInfos) {
		InfoMergerBuilderV3<StoreInfo, StorapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreVisiMergeStorap());
		InfoMergerV3<StoreInfo, StorapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoreInfo> mergeWithComp(List<StoreInfo> baseInfos, List<CompInfo> selectedInfos) {
		InfoMergerBuilderV3<StoreInfo, CompInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreVisiMergeComp());
		InfoMergerV3<StoreInfo, CompInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoreInfo> mergeWithCurrency(List<StoreInfo> baseInfos, List<CurrencyInfo> selectedInfos) {
		InfoMergerBuilderV3<StoreInfo, CurrencyInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreVisiMergeCurrency());
		InfoMergerV3<StoreInfo, CurrencyInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoreInfo> mergeWithPerson(List<StoreInfo> baseInfos, List<PersonInfo> selectedInfos) {
		InfoMergerBuilderV3<StoreInfo, PersonInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreVisiMergePerson());
		InfoMergerV3<StoreInfo, PersonInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoreInfo> mergeWithPhone(List<StoreInfo> baseInfos, List<PhoneInfo> selectedInfos) {
		InfoMergerBuilderV3<StoreInfo, PhoneInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreVisiMergePhone());
		InfoMergerV3<StoreInfo, PhoneInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoreInfo> mergeWithTimezone(List<StoreInfo> baseInfos, List<TimezoneInfo> selectedInfos) {
		InfoMergerBuilderV3<StoreInfo, TimezoneInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreVisiMergeTimezone());
		InfoMergerV3<StoreInfo, TimezoneInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoreInfo> mergeWithUser(List<StoreInfo> baseInfos, List<UserInfo> selectedInfos) {
		InfoMergerBuilderV3<StoreInfo, UserInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreVisiMergeUser());
		InfoMergerV3<StoreInfo, UserInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoreInfo> mergeWithUsername(List<StoreInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilderV3<StoreInfo, UsernameInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreVisiMergeUsername());
		InfoMergerV3<StoreInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoreInfo> mergeToDelete(List<StoreInfo> baseInfos, List<StoreInfo> selectedInfos) {
		InfoMergerBuilderV3<StoreInfo, StoreInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreVisiMergeToDelete());
		InfoMergerV3<StoreInfo, StoreInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoreInfo> mergeToSelect(List<StoreInfo> baseInfos, List<StoreInfo> selectedInfos) {
		InfoMergerBuilderV3<StoreInfo, StoreInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreVisiMergeToSelect());
		InfoMergerV3<StoreInfo, StoreInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoreInfo> mergeToUpdate(List<StoreInfo> baseInfos, List<StoreInfo> selectedInfos) {
		InfoMergerBuilderV3<StoreInfo, StoreInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreVisiMergeToUpdate());
		InfoMergerV3<StoreInfo, StoreInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
