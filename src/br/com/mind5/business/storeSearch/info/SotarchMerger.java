package br.com.mind5.business.storeSearch.info;

import java.util.List;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.security.username.info.UsernameInfo;

public final class SotarchMerger {	
	public static List<SotarchInfo> mergeWithComplis(List<SotarchInfo> baseInfos, List<ComplisInfo> selectedInfos) {
		InfoMergerBuilder<SotarchInfo, ComplisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SotarchMergerVisiComplis());
		InfoMerger<SotarchInfo, ComplisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SotarchInfo> mergeWithUsername(List<SotarchInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<SotarchInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SotarchMergerVisiUsername());
		InfoMerger<SotarchInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SotarchInfo> mergeToSelect(List<SotarchInfo> baseInfos, List<SotarchInfo> selectedInfos) {
		InfoMergerBuilder<SotarchInfo, SotarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SotarchMergerVisiToSelect());
		InfoMerger<SotarchInfo, SotarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
