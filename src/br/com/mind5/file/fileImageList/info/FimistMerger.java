package br.com.mind5.file.fileImageList.info;

import java.util.List;

import br.com.mind5.file.fileImageSearch.info.FimarchInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class FimistMerger {	
	public static List<FimistInfo> mergeWithFimarch(List<FimistInfo> baseInfos, List<FimarchInfo> selectedInfos) {
		InfoMergerBuilderV3<FimistInfo, FimarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new FimistVisiMergeFimarch());
		InfoMergerV3<FimistInfo, FimarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<FimistInfo> mergeToSelect(List<FimistInfo> baseInfos, List<FimistInfo> selectedInfos) {
		InfoMergerBuilderV3<FimistInfo, FimistInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new FimistVisiMergeToSelect());
		InfoMergerV3<FimistInfo, FimistInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
