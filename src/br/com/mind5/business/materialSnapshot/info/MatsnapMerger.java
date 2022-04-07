package br.com.mind5.business.materialSnapshot.info;

import java.util.List;

import br.com.mind5.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.masterData.materialCategory.info.MategInfo;
import br.com.mind5.masterData.materialGroup.info.MatoupInfo;
import br.com.mind5.masterData.materialSubgroup.info.MatubupInfo;
import br.com.mind5.masterData.materialType.info.MatypeInfo;
import br.com.mind5.masterData.materialUnit.info.MatunitInfo;

public final class MatsnapMerger {	
	public static List<MatsnapInfo> mergeWithMatubup(List<MatsnapInfo> baseInfos, List<MatubupInfo> selectedInfos) {
		InfoMergerBuilder<MatsnapInfo, MatubupInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatsnapMergerVisiMatubup());
		InfoMerger<MatsnapInfo, MatubupInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatsnapInfo> mergeWithMateg(List<MatsnapInfo> baseInfos, List<MategInfo> selectedInfos) {
		InfoMergerBuilder<MatsnapInfo, MategInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatsnapMergerVisiMateg());
		InfoMerger<MatsnapInfo, MategInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatsnapInfo> mergeWithMatoup(List<MatsnapInfo> baseInfos, List<MatoupInfo> selectedInfos) {
		InfoMergerBuilder<MatsnapInfo, MatoupInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatsnapMergerVisiMatoup());
		InfoMerger<MatsnapInfo, MatoupInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatsnapInfo> mergeWithMatype(List<MatsnapInfo> baseInfos, List<MatypeInfo> selectedInfos) {
		InfoMergerBuilder<MatsnapInfo, MatypeInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatsnapMergerVisiMatype());
		InfoMerger<MatsnapInfo, MatypeInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatsnapInfo> mergeWithMatunit(List<MatsnapInfo> baseInfos, List<MatunitInfo> selectedInfos) {
		InfoMergerBuilder<MatsnapInfo, MatunitInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatsnapMergerVisiMatunit());
		InfoMerger<MatsnapInfo, MatunitInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatsnapInfo> mergeWithMatextsnap(List<MatsnapInfo> baseInfos, List<MatextsnapInfo> selectedInfos) {
		InfoMergerBuilder<MatsnapInfo, MatextsnapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatsnapMergerVisiMatextsnap());
		InfoMerger<MatsnapInfo, MatextsnapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatsnapInfo> mergeToSelect(List<MatsnapInfo> baseInfos, List<MatsnapInfo> selectedInfos) {
		InfoMergerBuilder<MatsnapInfo, MatsnapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatsnapMergerVisiToSelect());
		InfoMerger<MatsnapInfo, MatsnapInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
