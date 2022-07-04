package br.com.mind5.business.store.info;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.storeAccount.info.StoracInfo;
import br.com.mind5.business.storeLunchTime.info.StuntmInfo;
import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.file.fileImageDecorated.info.FimecoInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.currency.info.CurrencyInfo;
import br.com.mind5.masterData.timezone.info.TimezoneInfo;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonth.info.StefilonInfo;

public final class StoreMerger {
	public static List<StoreInfo> mergeWithMatore(List<StoreInfo> baseInfos, List<MatoreInfo> selectedInfos) {
		InfoMergerBuilder<StoreInfo, MatoreInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreMergerVisiMatore());
		InfoMerger<StoreInfo, MatoreInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoreInfo> mergeWithStuntm(List<StoreInfo> baseInfos, List<StuntmInfo> selectedInfos) {
		InfoMergerBuilder<StoreInfo, StuntmInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreMergerVisiStuntm());
		InfoMerger<StoreInfo, StuntmInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoreInfo> mergeWithStowotm(List<StoreInfo> baseInfos, List<StowotmInfo> selectedInfos) {
		InfoMergerBuilder<StoreInfo, StowotmInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreMergerVisiStowotm());
		InfoMerger<StoreInfo, StowotmInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoreInfo> mergeWithStefilon(List<StoreInfo> baseInfos, List<StefilonInfo> selectedInfos) {
		InfoMergerBuilder<StoreInfo, StefilonInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreMergerVisiStefilon());
		InfoMerger<StoreInfo, StefilonInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoreInfo> mergeWithStorac(List<StoreInfo> baseInfos, List<StoracInfo> selectedInfos) {
		InfoMergerBuilder<StoreInfo, StoracInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreMergerVisiStorac());
		InfoMerger<StoreInfo, StoracInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoreInfo> mergeWithStorext(List<StoreInfo> baseInfos, List<StorextInfo> selectedInfos) {
		InfoMergerBuilder<StoreInfo, StorextInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreMergerVisiStorext());
		InfoMerger<StoreInfo, StorextInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoreInfo> mergeWithFimeco(List<StoreInfo> baseInfos, List<FimecoInfo> selectedInfos) {
		InfoMergerBuilder<StoreInfo, FimecoInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreMergerVisiFimeco());
		InfoMerger<StoreInfo, FimecoInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoreInfo> mergeWithSotarch(List<StoreInfo> baseInfos, List<SotarchInfo> selectedInfos) {
		InfoMergerBuilder<StoreInfo, SotarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreMergerVisiSotarch());
		InfoMerger<StoreInfo, SotarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoreInfo> mergeWithAddress(List<StoreInfo> baseInfos, List<AddressInfo> selectedInfos) {
		InfoMergerBuilder<StoreInfo, AddressInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreMergerVisiAddress());
		InfoMerger<StoreInfo, AddressInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoreInfo> mergeWithStorap(List<StoreInfo> baseInfos, List<StorapInfo> selectedInfos) {
		InfoMergerBuilder<StoreInfo, StorapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreMergerVisiStorap());
		InfoMerger<StoreInfo, StorapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoreInfo> mergeWithComp(List<StoreInfo> baseInfos, List<CompInfo> selectedInfos) {
		InfoMergerBuilder<StoreInfo, CompInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreMergerVisiComp());
		InfoMerger<StoreInfo, CompInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoreInfo> mergeWithCurrency(List<StoreInfo> baseInfos, List<CurrencyInfo> selectedInfos) {
		InfoMergerBuilder<StoreInfo, CurrencyInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreMergerVisiCurrency());
		InfoMerger<StoreInfo, CurrencyInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoreInfo> mergeWithPerson(List<StoreInfo> baseInfos, List<PersonInfo> selectedInfos) {
		InfoMergerBuilder<StoreInfo, PersonInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreMergerVisiPerson());
		InfoMerger<StoreInfo, PersonInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoreInfo> mergeWithPhone(List<StoreInfo> baseInfos, List<PhoneInfo> selectedInfos) {
		InfoMergerBuilder<StoreInfo, PhoneInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreMergerVisiPhone());
		InfoMerger<StoreInfo, PhoneInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoreInfo> mergeWithTimezone(List<StoreInfo> baseInfos, List<TimezoneInfo> selectedInfos) {
		InfoMergerBuilder<StoreInfo, TimezoneInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreMergerVisiTimezone());
		InfoMerger<StoreInfo, TimezoneInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoreInfo> mergeWithUser(List<StoreInfo> baseInfos, List<UserInfo> selectedInfos) {
		InfoMergerBuilder<StoreInfo, UserInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreMergerVisiUser());
		InfoMerger<StoreInfo, UserInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoreInfo> mergeWithUsername(List<StoreInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<StoreInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreMergerVisiUsername());
		InfoMerger<StoreInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoreInfo> mergeToDelete(List<StoreInfo> baseInfos, List<StoreInfo> selectedInfos) {
		InfoMergerBuilder<StoreInfo, StoreInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreMergerVisiToDelete());
		InfoMerger<StoreInfo, StoreInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoreInfo> mergeToSelect(List<StoreInfo> baseInfos, List<StoreInfo> selectedInfos) {
		InfoMergerBuilder<StoreInfo, StoreInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreMergerVisiToSelect());
		InfoMerger<StoreInfo, StoreInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoreInfo> mergeToUpdate(List<StoreInfo> baseInfos, List<StoreInfo> selectedInfos) {
		InfoMergerBuilder<StoreInfo, StoreInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoreMergerVisiToUpdate());
		InfoMerger<StoreInfo, StoreInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
