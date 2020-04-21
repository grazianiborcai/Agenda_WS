package br.com.mind5.masterData.materialGroup.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.businessArea.info.BusareaInfo;
import br.com.mind5.masterData.materialGroupSearch.info.MatouparchInfo;

public final class MatoupMerger {
	public static List<MatoupInfo> mergeWithMatouparch(List<MatoupInfo> baseInfos, List<MatouparchInfo> selectedInfos) {
		InfoMergerBuilderV3<MatoupInfo, MatouparchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatoupVisiMergeMatouparch());
		InfoMergerV3<MatoupInfo, MatouparchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatoupInfo> mergeWithBusarea(List<MatoupInfo> baseInfos, List<BusareaInfo> selectedInfos) {
		InfoMergerBuilderV3<MatoupInfo, BusareaInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatoupVisiMergeBusarea());
		InfoMergerV3<MatoupInfo, BusareaInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
