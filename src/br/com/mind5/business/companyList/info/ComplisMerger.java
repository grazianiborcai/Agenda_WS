package br.com.mind5.business.companyList.info;

import java.util.List;

import br.com.mind5.business.companySearch.info.ComparchInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class ComplisMerger {	
	public static List<ComplisInfo> mergeWithComparch(List<ComplisInfo> baseInfos, List<ComparchInfo> selectedInfos) {
		InfoMergerBuilderV3<ComplisInfo, ComparchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new ComplisVisiMergeComparch());
		InfoMergerV3<ComplisInfo, ComparchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<ComplisInfo> mergeToSelect(List<ComplisInfo> baseInfos, List<ComplisInfo> selectedInfos) {
		InfoMergerBuilderV3<ComplisInfo, ComplisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new ComplisVisiMergeToSelect());
		InfoMergerV3<ComplisInfo, ComplisInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
