package br.com.mind5.business.customerList.info;


import java.util.List;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class CuslisMerger {
	public static List<CuslisInfo> mergeWithFimist(List<CuslisInfo> baseInfos, List<FimistInfo> selectedInfos) {
		InfoMergerBuilderV3<CuslisInfo, FimistInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CuslisVisiMergeFimist());
		InfoMergerV3<CuslisInfo, FimistInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CuslisInfo> mergeWithCusarch(List<CuslisInfo> baseInfos, List<CusarchInfo> selectedInfos) {
		InfoMergerBuilderV3<CuslisInfo, CusarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CuslisVisiMergeCusarch());
		InfoMergerV3<CuslisInfo, CusarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CuslisInfo> mergeWithPersolis(List<CuslisInfo> baseInfos, List<PersolisInfo> selectedInfos) {
		InfoMergerBuilderV3<CuslisInfo, PersolisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CuslisVisiMergePersolis());
		InfoMergerV3<CuslisInfo, PersolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CuslisInfo> mergeToSelect(List<CuslisInfo> baseInfos, List<CuslisInfo> selectedInfos) {
		InfoMergerBuilderV3<CuslisInfo, CuslisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CuslisVisiMergeToSelect());
		InfoMergerV3<CuslisInfo, CuslisInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
