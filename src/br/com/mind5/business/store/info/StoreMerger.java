package br.com.mind5.business.store.info;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.masterData.currency.info.CurrencyInfo;
import br.com.mind5.masterData.timezone.info.TimezoneInfo;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class StoreMerger {
	public static List<StoreInfo> mergeWithStorext(List<StoreInfo> baseInfos, List<StorextInfo> selectedInfos) {
		InfoMergerBuilder<StoreInfo, StorextInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreVisiMergeStorext());
		InfoMerger<StoreInfo, StorextInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoreInfo> mergeWithFimist(List<StoreInfo> baseInfos, List<FimistInfo> selectedInfos) {
		InfoMergerBuilder<StoreInfo, FimistInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreVisiMergeFimist());
		InfoMerger<StoreInfo, FimistInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoreInfo> mergeWithSotarch(List<StoreInfo> baseInfos, List<SotarchInfo> selectedInfos) {
		InfoMergerBuilder<StoreInfo, SotarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreVisiMergeSotarch());
		InfoMerger<StoreInfo, SotarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoreInfo> mergeWithAddress(List<StoreInfo> baseInfos, List<AddressInfo> selectedInfos) {
		InfoMergerBuilder<StoreInfo, AddressInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreVisiMergeAddress());
		InfoMerger<StoreInfo, AddressInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoreInfo> mergeWithStorap(List<StoreInfo> baseInfos, List<StorapInfo> selectedInfos) {
		InfoMergerBuilder<StoreInfo, StorapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreVisiMergeStorap());
		InfoMerger<StoreInfo, StorapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoreInfo> mergeWithComp(List<StoreInfo> baseInfos, List<CompInfo> selectedInfos) {
		InfoMergerBuilder<StoreInfo, CompInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreVisiMergeComp());
		InfoMerger<StoreInfo, CompInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoreInfo> mergeWithCurrency(List<StoreInfo> baseInfos, List<CurrencyInfo> selectedInfos) {
		InfoMergerBuilder<StoreInfo, CurrencyInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreVisiMergeCurrency());
		InfoMerger<StoreInfo, CurrencyInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoreInfo> mergeWithPerson(List<StoreInfo> baseInfos, List<PersonInfo> selectedInfos) {
		InfoMergerBuilder<StoreInfo, PersonInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreVisiMergePerson());
		InfoMerger<StoreInfo, PersonInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoreInfo> mergeWithPhone(List<StoreInfo> baseInfos, List<PhoneInfo> selectedInfos) {
		InfoMergerBuilder<StoreInfo, PhoneInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreVisiMergePhone());
		InfoMerger<StoreInfo, PhoneInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoreInfo> mergeWithTimezone(List<StoreInfo> baseInfos, List<TimezoneInfo> selectedInfos) {
		InfoMergerBuilder<StoreInfo, TimezoneInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreVisiMergeTimezone());
		InfoMerger<StoreInfo, TimezoneInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoreInfo> mergeWithUser(List<StoreInfo> baseInfos, List<UserInfo> selectedInfos) {
		InfoMergerBuilder<StoreInfo, UserInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreVisiMergeUser());
		InfoMerger<StoreInfo, UserInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoreInfo> mergeWithUsername(List<StoreInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<StoreInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreVisiMergeUsername());
		InfoMerger<StoreInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoreInfo> mergeToDelete(List<StoreInfo> baseInfos, List<StoreInfo> selectedInfos) {
		InfoMergerBuilder<StoreInfo, StoreInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreVisiMergeToDelete());
		InfoMerger<StoreInfo, StoreInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoreInfo> mergeToSelect(List<StoreInfo> baseInfos, List<StoreInfo> selectedInfos) {
		InfoMergerBuilder<StoreInfo, StoreInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreVisiMergeToSelect());
		InfoMerger<StoreInfo, StoreInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoreInfo> mergeToUpdate(List<StoreInfo> baseInfos, List<StoreInfo> selectedInfos) {
		InfoMergerBuilder<StoreInfo, StoreInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreVisiMergeToUpdate());
		InfoMerger<StoreInfo, StoreInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
