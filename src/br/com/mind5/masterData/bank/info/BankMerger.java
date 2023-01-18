package br.com.mind5.masterData.bank.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.country.info.CountryInfo;

public final class BankMerger {	
	public static List<BankInfo> mergeWithCountry(List<BankInfo> baseInfos, List<CountryInfo> selectedInfos) {
		InfoMergerBuilder<BankInfo, CountryInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new BankMergerVisiCountry());
		InfoMerger<BankInfo, CountryInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
