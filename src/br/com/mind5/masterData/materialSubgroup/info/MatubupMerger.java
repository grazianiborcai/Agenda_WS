package br.com.mind5.masterData.materialSubgroup.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.masterData.materialGroup.info.MatoupInfo;
import br.com.mind5.masterData.materialSubgroupSearch.info.MatubuparchInfo;

public final class MatubupMerger {
	public static List<MatubupInfo> mergeWithMatubuparch(List<MatubupInfo> baseInfos, List<MatubuparchInfo> selectedInfos) {
		InfoMergerBuilder<MatubupInfo, MatubuparchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatubupMergerVisiMatubuparch());
		InfoMerger<MatubupInfo, MatubuparchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatubupInfo> mergeWithMatoup(List<MatubupInfo> baseInfos, List<MatoupInfo> selectedInfos) {
		InfoMergerBuilder<MatubupInfo, MatoupInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatubupMergerVisiMatoup());
		InfoMerger<MatubupInfo, MatoupInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
