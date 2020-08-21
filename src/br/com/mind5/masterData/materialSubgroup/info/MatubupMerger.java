package br.com.mind5.masterData.materialSubgroup.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.materialGroup.info.MatoupInfo;
import br.com.mind5.masterData.materialGroupSearch.info.MatouparchInfo;

public final class MatubupMerger {
	public static List<MatubupInfo> mergeWithMatouparch(List<MatubupInfo> baseInfos, List<MatouparchInfo> selectedInfos) {
		InfoMergerBuilderV3<MatubupInfo, MatouparchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatubupVisiMergeMatouparch());
		InfoMergerV3<MatubupInfo, MatouparchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatubupInfo> mergeWithMatoup(List<MatubupInfo> baseInfos, List<MatoupInfo> selectedInfos) {
		InfoMergerBuilderV3<MatubupInfo, MatoupInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatubupVisiMergeMatoup());
		InfoMergerV3<MatubupInfo, MatoupInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
