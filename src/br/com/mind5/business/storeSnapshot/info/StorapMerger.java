package br.com.mind5.business.storeSnapshot.info;

import java.util.List;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.business.companySnapshot.info.CompnapInfo;
import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.masterData.currency.info.CurrencyInfo;
import br.com.mind5.masterData.timezone.info.TimezoneInfo;
import br.com.mind5.security.userList.info.UselisInfo;

public final class StorapMerger {	
	public static List<StorapInfo> mergeWithStorext(List<StorapInfo> baseInfos, List<StorextInfo> selectedInfos) {
		InfoMergerBuilder<StorapInfo, StorextInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorapVisiMergeStorext());
		InfoMerger<StorapInfo, StorextInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorapInfo> mergeWithComplis(List<StorapInfo> baseInfos, List<ComplisInfo> selectedInfos) {
		InfoMergerBuilder<StorapInfo, ComplisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorapVisiMergeComplis());
		InfoMerger<StorapInfo, ComplisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorapInfo> mergeWithCompnap(List<StorapInfo> baseInfos, List<CompnapInfo> selectedInfos) {
		InfoMergerBuilder<StorapInfo, CompnapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorapVisiMergeCompnap());
		InfoMerger<StorapInfo, CompnapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorapInfo> mergeWithCurrency(List<StorapInfo> baseInfos, List<CurrencyInfo> selectedInfos) {
		InfoMergerBuilder<StorapInfo, CurrencyInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorapVisiMergeCurrency());
		InfoMerger<StorapInfo, CurrencyInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorapInfo> mergeWithPersolis(List<StorapInfo> baseInfos, List<PersolisInfo> selectedInfos) {
		InfoMergerBuilder<StorapInfo, PersolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorapVisiMergePersolis());
		InfoMerger<StorapInfo, PersolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorapInfo> mergeWithPersonap(List<StorapInfo> baseInfos, List<PersonapInfo> selectedInfos) {
		InfoMergerBuilder<StorapInfo, PersonapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorapVisiMergePersonap());
		InfoMerger<StorapInfo, PersonapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorapInfo> mergeWithPhonap(List<StorapInfo> baseInfos, List<PhonapInfo> selectedInfos) {
		InfoMergerBuilder<StorapInfo, PhonapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorapVisiMergePhonap());
		InfoMerger<StorapInfo, PhonapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorapInfo> mergeWithTimezone(List<StorapInfo> baseInfos, List<TimezoneInfo> selectedInfos) {
		InfoMergerBuilder<StorapInfo, TimezoneInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorapVisiMergeTimezone());
		InfoMerger<StorapInfo, TimezoneInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorapInfo> mergeWithUselis(List<StorapInfo> baseInfos, List<UselisInfo> selectedInfos) {
		InfoMergerBuilder<StorapInfo, UselisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorapVisiMergeUselis());
		InfoMerger<StorapInfo, UselisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorapInfo> mergeToSelect(List<StorapInfo> baseInfos, List<StorapInfo> selectedInfos) {
		InfoMergerBuilder<StorapInfo, StorapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorapVisiMergeToSelect());
		InfoMerger<StorapInfo, StorapInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
