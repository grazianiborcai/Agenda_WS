package br.com.mind5.business.materialList.info;

import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.file.fileImageDecorated.info.FimecoInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.materialCategory.info.MategInfo;
import br.com.mind5.masterData.materialGroup.info.MatoupInfo;
import br.com.mind5.masterData.materialSubgroup.info.MatubupInfo;
import br.com.mind5.masterData.materialType.info.MatypeInfo;
import br.com.mind5.masterData.materialUnit.info.MatunitInfo;

public final class MatlisMerger {
	public static List<MatlisInfo> mergeWithSytotauh(List<MatlisInfo> baseInfos, List<SytotauhInfo> selectedInfos) {
		InfoMergerBuilder<MatlisInfo, SytotauhInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatlisMergerVisiSytotauh());
		InfoMerger<MatlisInfo, SytotauhInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatlisInfo> mergeWithMatubup(List<MatlisInfo> baseInfos, List<MatubupInfo> selectedInfos) {
		InfoMergerBuilder<MatlisInfo, MatubupInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatlisMergerVisiMatubup());
		InfoMerger<MatlisInfo, MatubupInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatlisInfo> mergeWithFimeco(List<MatlisInfo> baseInfos, List<FimecoInfo> selectedInfos) {
		InfoMergerBuilder<MatlisInfo, FimecoInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatlisMergerVisiFimeco());
		InfoMerger<MatlisInfo, FimecoInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatlisInfo> mergeWithMatarch(List<MatlisInfo> baseInfos, List<MatarchInfo> selectedInfos) {
		InfoMergerBuilder<MatlisInfo, MatarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatlisMergerVisiMatarch());
		InfoMerger<MatlisInfo, MatarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatlisInfo> mergeWithMateg(List<MatlisInfo> baseInfos, List<MategInfo> selectedInfos) {
		InfoMergerBuilder<MatlisInfo, MategInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatlisMergerVisiMateg());
		InfoMerger<MatlisInfo, MategInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<MatlisInfo> mergeWithMatext(List<MatlisInfo> baseInfos, List<MatextInfo> selectedInfos) {
		InfoMergerBuilder<MatlisInfo, MatextInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatlisMergerVisiMatext());
		InfoMerger<MatlisInfo, MatextInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatlisInfo> mergeWithMatype(List<MatlisInfo> baseInfos, List<MatypeInfo> selectedInfos) {
		InfoMergerBuilder<MatlisInfo, MatypeInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatlisMergerVisiMatype());
		InfoMerger<MatlisInfo, MatypeInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatlisInfo> mergeWithMatoup(List<MatlisInfo> baseInfos, List<MatoupInfo> selectedInfos) {
		InfoMergerBuilder<MatlisInfo, MatoupInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatlisMergerVisiMatoup());
		InfoMerger<MatlisInfo, MatoupInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatlisInfo> mergeWithMatunit(List<MatlisInfo> baseInfos, List<MatunitInfo> selectedInfos) {
		InfoMergerBuilder<MatlisInfo, MatunitInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatlisMergerVisiMatunit());
		InfoMerger<MatlisInfo, MatunitInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatlisInfo> mergeToSelect(List<MatlisInfo> baseInfos, List<MatlisInfo> selectedInfos) {
		InfoMergerBuilder<MatlisInfo, MatlisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatlisMergerVisiToSelect());
		InfoMerger<MatlisInfo, MatlisInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
