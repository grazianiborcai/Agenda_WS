package br.com.mind5.business.employeePosition.info;

import java.util.List;

import br.com.mind5.business.employeePositionSearch.info.EmposarchInfo;
import br.com.mind5.business.employeeRestricted.info.EmplresInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.position.info.PositionInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class EmposMerger {
	public static List<EmposInfo> mergeWithEmplres(List<EmposInfo> baseInfos, List<EmplresInfo> selectedInfos) {
		InfoMergerBuilder<EmposInfo, EmplresInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmposVisiMergeEmplres());
		InfoMerger<EmposInfo, EmplresInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmposInfo> mergeWithEmposarch(List<EmposInfo> baseInfos, List<EmposarchInfo> selectedInfos) {
		InfoMergerBuilder<EmposInfo, EmposarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmposVisiMergeEmposarch());
		InfoMerger<EmposInfo, EmposarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmposInfo> mergeWithPosition(List<EmposInfo> baseInfos, List<PositionInfo> selectedInfos) {
		InfoMergerBuilder<EmposInfo, PositionInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmposVisiMergePosition());
		InfoMerger<EmposInfo, PositionInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmposInfo> mergeWithUsername(List<EmposInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<EmposInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmposVisiMergeUsername());
		InfoMerger<EmposInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmposInfo> mergeToDelete(List<EmposInfo> baseInfos, List<EmposInfo> selectedInfos) {
		InfoMergerBuilder<EmposInfo, EmposInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmposVisiMergeToDelete());
		InfoMerger<EmposInfo, EmposInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmposInfo> mergeToSelect(List<EmposInfo> baseInfos, List<EmposInfo> selectedInfos) {
		InfoMergerBuilder<EmposInfo, EmposInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmposVisiMergeToSelect());
		InfoMerger<EmposInfo, EmposInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
