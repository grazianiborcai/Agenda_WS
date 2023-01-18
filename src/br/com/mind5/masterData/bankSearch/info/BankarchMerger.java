package br.com.mind5.masterData.bankSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.country.info.CountryInfo;

public final class BankarchMerger {	
	public static List<BankarchInfo> mergeWithCountry(List<BankarchInfo> baseInfos, List<CountryInfo> selectedInfos) {
		InfoMergerBuilder<BankarchInfo, CountryInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new BankarchMergerVisiCountry());
		InfoMerger<BankarchInfo, CountryInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
