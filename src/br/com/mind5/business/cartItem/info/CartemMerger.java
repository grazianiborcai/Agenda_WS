package br.com.mind5.business.cartItem.info;

import java.util.List;

import br.com.mind5.business.cartItemSearch.info.CartemarchInfo;
import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class CartemMerger {
	public static List<CartemInfo> mergeWithSymsg(List<CartemInfo> baseInfos, List<SymsgInfo> selectedInfos) {
		InfoMergerBuilderV3<CartemInfo, SymsgInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CartemVisiMergeSymsg());
		InfoMergerV3<CartemInfo, SymsgInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CartemInfo> mergeWithCartemarch(List<CartemInfo> baseInfos, List<CartemarchInfo> selectedInfos) {
		InfoMergerBuilderV3<CartemInfo, CartemarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CartemVisiMergeCartemarch());
		InfoMergerV3<CartemInfo, CartemarchInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CartemInfo> mergeWithMatlis(List<CartemInfo> baseInfos, List<MatlisInfo> selectedInfos) {
		InfoMergerBuilderV3<CartemInfo, MatlisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CartemVisiMergeMatlis());
		InfoMergerV3<CartemInfo, MatlisInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CartemInfo> mergeWithEmplis(List<CartemInfo> baseInfos, List<EmplisInfo> selectedInfos) {
		InfoMergerBuilderV3<CartemInfo, EmplisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CartemVisiMergeEmplis());
		InfoMergerV3<CartemInfo, EmplisInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CartemInfo> mergeWithStolis(List<CartemInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilderV3<CartemInfo, StolisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CartemVisiMergeStolis());
		InfoMergerV3<CartemInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CartemInfo> mergeWithUsername(List<CartemInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilderV3<CartemInfo, UsernameInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CartemVisiMergeUsername());
		InfoMergerV3<CartemInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}		
	
	
	
	public static List<CartemInfo> mergeWithMatore(List<CartemInfo> baseInfos, List<MatoreInfo> selectedInfos) {
		InfoMergerBuilderV3<CartemInfo, MatoreInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CartemVisiMergeMatore());
		InfoMergerV3<CartemInfo, MatoreInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CartemInfo> mergeWithWeekday(List<CartemInfo> baseInfos, List<WeekdayInfo> selectedInfos) {
		InfoMergerBuilderV3<CartemInfo, WeekdayInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CartemVisiMergeWeekday());
		InfoMergerV3<CartemInfo, WeekdayInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CartemInfo> mergeToUpdate(List<CartemInfo> baseInfos, List<CartemInfo> selectedInfos) {
		InfoMergerBuilderV3<CartemInfo, CartemInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CartemVisiMergeToUpdate());
		InfoMergerV3<CartemInfo, CartemInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CartemInfo> mergeToSelect(List<CartemInfo> baseInfos, List<CartemInfo> selectedInfos) {
		InfoMergerBuilderV3<CartemInfo, CartemInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CartemVisiMergeToSelect());
		InfoMergerV3<CartemInfo, CartemInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
