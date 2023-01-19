package br.com.mind5.business.storeSnapshot.info;

import java.util.List;

import br.com.mind5.business.bankAccount.info.BankaccInfo;
import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.business.companySnapshot.info.CompnapInfo;
import br.com.mind5.business.personLegal.info.PeregInfo;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.currency.info.CurrencyInfo;
import br.com.mind5.masterData.timezone.info.TimezoneInfo;
import br.com.mind5.security.userList.info.UselisInfo;

public final class StorapMerger {	
	public static List<StorapInfo> mergeWithBankacc(List<StorapInfo> baseInfos, List<BankaccInfo> selectedInfos) {
		InfoMergerBuilder<StorapInfo, BankaccInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorapMergerVisiBankacc());
		InfoMerger<StorapInfo, BankaccInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorapInfo> mergeWithStorext(List<StorapInfo> baseInfos, List<StorextInfo> selectedInfos) {
		InfoMergerBuilder<StorapInfo, StorextInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorapMergerVisiStorext());
		InfoMerger<StorapInfo, StorextInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorapInfo> mergeWithComplis(List<StorapInfo> baseInfos, List<ComplisInfo> selectedInfos) {
		InfoMergerBuilder<StorapInfo, ComplisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorapMergerVisiComplis());
		InfoMerger<StorapInfo, ComplisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorapInfo> mergeWithCompnap(List<StorapInfo> baseInfos, List<CompnapInfo> selectedInfos) {
		InfoMergerBuilder<StorapInfo, CompnapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorapMergerVisiCompnap());
		InfoMerger<StorapInfo, CompnapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorapInfo> mergeWithCurrency(List<StorapInfo> baseInfos, List<CurrencyInfo> selectedInfos) {
		InfoMergerBuilder<StorapInfo, CurrencyInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorapMergerVisiCurrency());
		InfoMerger<StorapInfo, CurrencyInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorapInfo> mergeWithPereg(List<StorapInfo> baseInfos, List<PeregInfo> selectedInfos) {
		InfoMergerBuilder<StorapInfo, PeregInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorapMergerVisiPersonap());
		InfoMerger<StorapInfo, PeregInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorapInfo> mergeWithPhonap(List<StorapInfo> baseInfos, List<PhonapInfo> selectedInfos) {
		InfoMergerBuilder<StorapInfo, PhonapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorapMergerVisiPhonap());
		InfoMerger<StorapInfo, PhonapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorapInfo> mergeWithTimezone(List<StorapInfo> baseInfos, List<TimezoneInfo> selectedInfos) {
		InfoMergerBuilder<StorapInfo, TimezoneInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorapMergerVisiTimezone());
		InfoMerger<StorapInfo, TimezoneInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorapInfo> mergeWithUselis(List<StorapInfo> baseInfos, List<UselisInfo> selectedInfos) {
		InfoMergerBuilder<StorapInfo, UselisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorapMergerVisiUselis());
		InfoMerger<StorapInfo, UselisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorapInfo> mergeToSelect(List<StorapInfo> baseInfos, List<StorapInfo> selectedInfos) {
		InfoMergerBuilder<StorapInfo, StorapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorapMergerVisiToSelect());
		InfoMerger<StorapInfo, StorapInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
