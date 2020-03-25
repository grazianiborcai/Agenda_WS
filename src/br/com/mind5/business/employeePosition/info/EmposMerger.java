package br.com.mind5.business.employeePosition.info;

import java.util.List;

import br.com.mind5.business.employeePositionSearch.info.EmposarchInfo;
import br.com.mind5.business.masterData.info.PositionInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.security.username.info.UsernameInfo;

public final class EmposMerger {
	public static List<EmposInfo> mergeWithEmposarch(List<EmposInfo> baseInfos, List<EmposarchInfo> selectedInfos) {
		InfoMergerBuilderV3<EmposInfo, EmposarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmposVisiMergeEmposarch());
		InfoMergerV3<EmposInfo, EmposarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmposInfo> mergeWithPosition(List<EmposInfo> baseInfos, List<PositionInfo> selectedInfos) {
		InfoMergerBuilderV3<EmposInfo, PositionInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmposVisiMergePosition());
		InfoMergerV3<EmposInfo, PositionInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmposInfo> mergeWithUsername(List<EmposInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilderV3<EmposInfo, UsernameInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmposVisiMergeUsername());
		InfoMergerV3<EmposInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmposInfo> mergeToDelete(List<EmposInfo> baseInfos, List<EmposInfo> selectedInfos) {
		InfoMergerBuilderV3<EmposInfo, EmposInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmposVisiMergeToDelete());
		InfoMergerV3<EmposInfo, EmposInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmposInfo> mergeToSelect(List<EmposInfo> baseInfos, List<EmposInfo> selectedInfos) {
		InfoMergerBuilderV3<EmposInfo, EmposInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmposVisiMergeToSelect());
		InfoMergerV3<EmposInfo, EmposInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
