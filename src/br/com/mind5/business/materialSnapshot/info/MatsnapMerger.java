package br.com.mind5.business.materialSnapshot.info;

import java.util.List;

import br.com.mind5.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.materialCategory.info.MategInfo;
import br.com.mind5.masterData.materialGroup.info.MatoupInfo;
import br.com.mind5.masterData.materialSubgroup.info.MatubupInfo;
import br.com.mind5.masterData.materialType.info.MatypeInfo;
import br.com.mind5.masterData.materialUnit.info.MatunitInfo;

public final class MatsnapMerger {	
	public static List<MatsnapInfo> mergeWithMatubup(List<MatsnapInfo> baseInfos, List<MatubupInfo> selectedInfos) {
		InfoMergerBuilderV3<MatsnapInfo, MatubupInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatsnapVisiMergeMatubup());
		InfoMergerV3<MatsnapInfo, MatubupInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatsnapInfo> mergeWithMateg(List<MatsnapInfo> baseInfos, List<MategInfo> selectedInfos) {
		InfoMergerBuilderV3<MatsnapInfo, MategInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatsnapVisiMergeMateg());
		InfoMergerV3<MatsnapInfo, MategInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatsnapInfo> mergeWithMatoup(List<MatsnapInfo> baseInfos, List<MatoupInfo> selectedInfos) {
		InfoMergerBuilderV3<MatsnapInfo, MatoupInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatsnapVisiMergeMatoup());
		InfoMergerV3<MatsnapInfo, MatoupInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatsnapInfo> mergeWithMatype(List<MatsnapInfo> baseInfos, List<MatypeInfo> selectedInfos) {
		InfoMergerBuilderV3<MatsnapInfo, MatypeInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatsnapVisiMergeMatype());
		InfoMergerV3<MatsnapInfo, MatypeInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatsnapInfo> mergeWithMatunit(List<MatsnapInfo> baseInfos, List<MatunitInfo> selectedInfos) {
		InfoMergerBuilderV3<MatsnapInfo, MatunitInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatsnapVisiMergeMatunit());
		InfoMergerV3<MatsnapInfo, MatunitInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatsnapInfo> mergeWithMatextsnap(List<MatsnapInfo> baseInfos, List<MatextsnapInfo> selectedInfos) {
		InfoMergerBuilderV3<MatsnapInfo, MatextsnapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatsnapVisiMergeMatextsnap());
		InfoMergerV3<MatsnapInfo, MatextsnapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatsnapInfo> mergeToSelect(List<MatsnapInfo> baseInfos, List<MatsnapInfo> selectedInfos) {
		InfoMergerBuilderV3<MatsnapInfo, MatsnapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatsnapVisiMergeToSelect());
		InfoMergerV3<MatsnapInfo, MatsnapInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
