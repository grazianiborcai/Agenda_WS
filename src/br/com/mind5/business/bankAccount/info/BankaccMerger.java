package br.com.mind5.business.bankAccount.info;

import java.util.List;

import br.com.mind5.business.bankAccountSearch.info.BankaccarchInfo;
import br.com.mind5.business.bankAccountSnapshot.info.BankaccnapInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.bank.info.BankInfo;
import br.com.mind5.masterData.bankAccountType.info.BankacypeInfo;
import br.com.mind5.masterData.bankHolderType.info.BankoldypeInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class BankaccMerger {
	public static List<BankaccInfo> mergeWithBank(List<BankaccInfo> baseInfos, List<BankInfo> selectedInfos) {
		InfoMergerBuilder<BankaccInfo, BankInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new BankaccMergerVisiBank());
		InfoMerger<BankaccInfo, BankInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<BankaccInfo> mergeWithBankaccarch(List<BankaccInfo> baseInfos, List<BankaccarchInfo> selectedInfos) {
		InfoMergerBuilder<BankaccInfo, BankaccarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new BankaccMergerVisiBankaccarch());
		InfoMerger<BankaccInfo, BankaccarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<BankaccInfo> mergeWithUsername(List<BankaccInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<BankaccInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new BankaccMergerVisiUsername());
		InfoMerger<BankaccInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<BankaccInfo> mergeWithBankacype(List<BankaccInfo> baseInfos, List<BankacypeInfo> selectedInfos) {
		InfoMergerBuilder<BankaccInfo, BankacypeInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new BankaccMergerVisiBankacype());
		InfoMerger<BankaccInfo, BankacypeInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<BankaccInfo> mergeWithBankoldype(List<BankaccInfo> baseInfos, List<BankoldypeInfo> selectedInfos) {
		InfoMergerBuilder<BankaccInfo, BankoldypeInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new BankaccMergerVisiBankoldype());
		InfoMerger<BankaccInfo, BankoldypeInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<BankaccInfo> mergeWithBankaccnap(List<BankaccInfo> baseInfos, List<BankaccnapInfo> selectedInfos) {
		InfoMergerBuilder<BankaccInfo, BankaccnapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new BankaccMergerVisiBankaccnap());
		InfoMerger<BankaccInfo, BankaccnapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<BankaccInfo> mergeToSelect(List<BankaccInfo> baseInfos, List<BankaccInfo> selectedInfos) {
		InfoMergerBuilder<BankaccInfo, BankaccInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new BankaccMergerVisiToSelect());
		InfoMerger<BankaccInfo, BankaccInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<BankaccInfo> mergeToUpdate(List<BankaccInfo> baseInfos, List<BankaccInfo> selectedInfos) {
		InfoMergerBuilder<BankaccInfo, BankaccInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new BankaccMergerVisiToUpdate());
		InfoMerger<BankaccInfo, BankaccInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
