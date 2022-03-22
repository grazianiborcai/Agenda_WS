package br.com.mind5.business.customerList.info;


import java.util.List;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class CuslisMerger {
	public static List<CuslisInfo> mergeWithFimist(List<CuslisInfo> baseInfos, List<FimistInfo> selectedInfos) {
		InfoMergerBuilder<CuslisInfo, FimistInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CuslisMergerVisiFimist());
		InfoMerger<CuslisInfo, FimistInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CuslisInfo> mergeWithCusarch(List<CuslisInfo> baseInfos, List<CusarchInfo> selectedInfos) {
		InfoMergerBuilder<CuslisInfo, CusarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CuslisMergerVisiCusarch());
		InfoMerger<CuslisInfo, CusarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CuslisInfo> mergeWithPersolis(List<CuslisInfo> baseInfos, List<PersolisInfo> selectedInfos) {
		InfoMergerBuilder<CuslisInfo, PersolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CuslisMergerVisiPersolis());
		InfoMerger<CuslisInfo, PersolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CuslisInfo> mergeToSelect(List<CuslisInfo> baseInfos, List<CuslisInfo> selectedInfos) {
		InfoMergerBuilder<CuslisInfo, CuslisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CuslisMergerVisiToSelect());
		InfoMerger<CuslisInfo, CuslisInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
