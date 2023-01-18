package br.com.mind5.business.bankAccountSnapshot.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.bank.info.BankInfo;
import br.com.mind5.masterData.bankAccountType.info.BankacypeInfo;
import br.com.mind5.masterData.bankHolderType.info.BankoldypeInfo;

public final class BankaccnapMerger {
	public static List<BankaccnapInfo> mergeWithBank(List<BankaccnapInfo> baseInfos, List<BankInfo> selectedInfos) {
		InfoMergerBuilder<BankaccnapInfo, BankInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new BankaccnapMergerVisiBank());
		InfoMerger<BankaccnapInfo, BankInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<BankaccnapInfo> mergeWithBankacype(List<BankaccnapInfo> baseInfos, List<BankacypeInfo> selectedInfos) {
		InfoMergerBuilder<BankaccnapInfo, BankacypeInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new BankaccnapMergerVisiBankacype());
		InfoMerger<BankaccnapInfo, BankacypeInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<BankaccnapInfo> mergeWithBankoldype(List<BankaccnapInfo> baseInfos, List<BankoldypeInfo> selectedInfos) {
		InfoMergerBuilder<BankaccnapInfo, BankoldypeInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new BankaccnapMergerVisiBankoldype());
		InfoMerger<BankaccnapInfo, BankoldypeInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<BankaccnapInfo> mergeToSelect(List<BankaccnapInfo> baseInfos, List<BankaccnapInfo> selectedInfos) {
		InfoMergerBuilder<BankaccnapInfo, BankaccnapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new BankaccnapMergerVisiToSelect());
		InfoMerger<BankaccnapInfo, BankaccnapInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
