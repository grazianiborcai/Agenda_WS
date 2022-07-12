package br.com.mind5.file.fileImage.info;

import java.util.List;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.file.fileImageSearch.info.FimarchInfo;
import br.com.mind5.file.fileImageSnapshot.info.FimgnapInfo;
import br.com.mind5.file.filePath.info.FathInfo;
import br.com.mind5.file.fileRead.info.FreadInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.security.username.info.UsernameInfo;

public final class FimgMerger {	
	public static List<FimgInfo> mergeWithCusarch(List<FimgInfo> baseInfos, List<CusarchInfo> selectedInfos) {
		InfoMergerBuilder<FimgInfo, CusarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new FimgMergerVisiCusarch());
		InfoMerger<FimgInfo, CusarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<FimgInfo> mergeWithFimgnap(List<FimgInfo> baseInfos, List<FimgnapInfo> selectedInfos) {
		InfoMergerBuilder<FimgInfo, FimgnapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new FimgMergerVisiFimgnap());
		InfoMerger<FimgInfo, FimgnapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<FimgInfo> mergeWithFread(List<FimgInfo> baseInfos, List<FreadInfo> selectedInfos) {
		InfoMergerBuilder<FimgInfo, FreadInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new FimgMergerVisiFread());
		InfoMerger<FimgInfo, FreadInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<FimgInfo> mergeWithEmparch(List<FimgInfo> baseInfos, List<EmparchInfo> selectedInfos) {
		InfoMergerBuilder<FimgInfo, EmparchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new FimgMergerVisiEmparch());
		InfoMerger<FimgInfo, EmparchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<FimgInfo> mergeWithFimarch(List<FimgInfo> baseInfos, List<FimarchInfo> selectedInfos) {
		InfoMergerBuilder<FimgInfo, FimarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new FimgMergerVisiFimarch());
		InfoMerger<FimgInfo, FimarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<FimgInfo> mergeWithFath(List<FimgInfo> baseInfos, List<FathInfo> selectedInfos) {
		InfoMergerBuilder<FimgInfo, FathInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new FimgMergerVisiFath());
		InfoMerger<FimgInfo, FathInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<FimgInfo> mergeWithUsername(List<FimgInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<FimgInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new FimgMergerVisiUsername());
		InfoMerger<FimgInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<FimgInfo> mergeToReplace(List<FimgInfo> baseInfos, List<FimgInfo> selectedInfos) {
		InfoMergerBuilder<FimgInfo, FimgInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new FimgMergerVisiToReplace());
		InfoMerger<FimgInfo, FimgInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<FimgInfo> mergeToSelect(List<FimgInfo> baseInfos, List<FimgInfo> selectedInfos) {
		InfoMergerBuilder<FimgInfo, FimgInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new FimgMergerVisiToSelect());
		InfoMerger<FimgInfo, FimgInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<FimgInfo> mergeToDelete(List<FimgInfo> baseInfos, List<FimgInfo> selectedInfos) {
		InfoMergerBuilder<FimgInfo, FimgInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new FimgMergerVisiToDelete());
		InfoMerger<FimgInfo, FimgInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<FimgInfo> mergeToUpdate(List<FimgInfo> baseInfos, List<FimgInfo> selectedInfos) {
		InfoMergerBuilder<FimgInfo, FimgInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new FimgMergerVisiToUpdate());
		InfoMerger<FimgInfo, FimgInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<FimgInfo> mergeToCopy(List<FimgInfo> baseInfos, List<FimgInfo> selectedInfos) {
		InfoMergerBuilder<FimgInfo, FimgInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new FimgMergerVisiToCopy());
		InfoMerger<FimgInfo, FimgInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
