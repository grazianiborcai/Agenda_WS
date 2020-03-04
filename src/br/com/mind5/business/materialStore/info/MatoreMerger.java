package br.com.mind5.business.materialStore.info;

import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.business.materialStoreSearch.info.MatorarchInfo;
import br.com.mind5.business.materialStoreSnapshot.info.MatorapInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.security.username.info.UsernameInfo;

public final class MatoreMerger {
	public static List<MatoreInfo> mergeWithMatorap(List<MatoreInfo> baseInfos, List<MatorapInfo> selectedInfos) {
		InfoMergerBuilderV3<MatoreInfo, MatorapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatoreVisiMergeMatorap());
		InfoMergerV3<MatoreInfo, MatorapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatoreInfo> mergeWithMatorarch(List<MatoreInfo> baseInfos, List<MatorarchInfo> selectedInfos) {
		InfoMergerBuilderV3<MatoreInfo, MatorarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatoreVisiMergeMatorarch());
		InfoMergerV3<MatoreInfo, MatorarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatoreInfo> mergeWithMatlis(List<MatoreInfo> baseInfos, List<MatlisInfo> selectedInfos) {
		InfoMergerBuilderV3<MatoreInfo, MatlisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatoreVisiMergeMatlis());
		InfoMergerV3<MatoreInfo, MatlisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatoreInfo> mergeWithStolis(List<MatoreInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilderV3<MatoreInfo, StolisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatoreVisiMergeStolis());
		InfoMergerV3<MatoreInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatoreInfo> mergeWithMatock(List<MatoreInfo> baseInfos, List<MatockInfo> selectedInfos) {
		InfoMergerBuilderV3<MatoreInfo, MatockInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatoreVisiMergeMatock());
		InfoMergerV3<MatoreInfo, MatockInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatoreInfo> mergeWithUsername(List<MatoreInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilderV3<MatoreInfo, UsernameInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatoreVisiMergeUsername());
		InfoMergerV3<MatoreInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatoreInfo> mergeToSelect(List<MatoreInfo> baseInfos, List<MatoreInfo> selectedInfos) {
		InfoMergerBuilderV3<MatoreInfo, MatoreInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatoreVisiMergeToSelect());
		InfoMergerV3<MatoreInfo, MatoreInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatoreInfo> mergeToDelete(List<MatoreInfo> baseInfos, List<MatoreInfo> selectedInfos) {
		InfoMergerBuilderV3<MatoreInfo, MatoreInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatoreVisiMergeToDelete());
		InfoMergerV3<MatoreInfo, MatoreInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatoreInfo> mergeToUpdate(List<MatoreInfo> baseInfos, List<MatoreInfo> selectedInfos) {
		InfoMergerBuilderV3<MatoreInfo, MatoreInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatoreVisiMergeToUpdate());
		InfoMergerV3<MatoreInfo, MatoreInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
