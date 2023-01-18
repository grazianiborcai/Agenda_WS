package br.com.mind5.business.bankAccountSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class BankaccarchMerger {
	public static List<BankaccarchInfo> mergeToSelect(List<BankaccarchInfo> baseInfos, List<BankaccarchInfo> selectedInfos) {
		InfoMergerBuilder<BankaccarchInfo, BankaccarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new BankaccarchMergerVisiToSelect());
		InfoMerger<BankaccarchInfo, BankaccarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
