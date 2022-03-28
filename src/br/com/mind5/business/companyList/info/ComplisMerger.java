package br.com.mind5.business.companyList.info;

import java.util.List;

import br.com.mind5.business.companySearch.info.ComparchInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class ComplisMerger {	
	public static List<ComplisInfo> mergeWithComparch(List<ComplisInfo> baseInfos, List<ComparchInfo> selectedInfos) {
		InfoMergerBuilder<ComplisInfo, ComparchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new ComplisMergerVisiComparch());
		InfoMerger<ComplisInfo, ComparchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<ComplisInfo> mergeToSelect(List<ComplisInfo> baseInfos, List<ComplisInfo> selectedInfos) {
		InfoMergerBuilder<ComplisInfo, ComplisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new ComplisMergerVisiToSelect());
		InfoMerger<ComplisInfo, ComplisInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
