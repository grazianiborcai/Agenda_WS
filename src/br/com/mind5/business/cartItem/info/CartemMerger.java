package br.com.mind5.business.cartItem.info;

import java.util.List;

import br.com.mind5.business.cartItemSearch.info.CartemarchInfo;
import br.com.mind5.business.employeeRestricted.info.EmplresInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class CartemMerger {
	public static List<CartemInfo> mergeWithSymsg(List<CartemInfo> baseInfos, List<SymsgInfo> selectedInfos) {
		InfoMergerBuilder<CartemInfo, SymsgInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CartemVisiMergeSymsg());
		InfoMerger<CartemInfo, SymsgInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CartemInfo> mergeWithCartemarch(List<CartemInfo> baseInfos, List<CartemarchInfo> selectedInfos) {
		InfoMergerBuilder<CartemInfo, CartemarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CartemVisiMergeCartemarch());
		InfoMerger<CartemInfo, CartemarchInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CartemInfo> mergeWithMatlis(List<CartemInfo> baseInfos, List<MatlisInfo> selectedInfos) {
		InfoMergerBuilder<CartemInfo, MatlisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CartemVisiMergeMatlis());
		InfoMerger<CartemInfo, MatlisInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CartemInfo> mergeWithEmplres(List<CartemInfo> baseInfos, List<EmplresInfo> selectedInfos) {
		InfoMergerBuilder<CartemInfo, EmplresInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CartemVisiMergeEmplres());
		InfoMerger<CartemInfo, EmplresInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CartemInfo> mergeWithStolis(List<CartemInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilder<CartemInfo, StolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CartemVisiMergeStolis());
		InfoMerger<CartemInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CartemInfo> mergeWithUsername(List<CartemInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<CartemInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CartemVisiMergeUsername());
		InfoMerger<CartemInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}		
	
	
	
	public static List<CartemInfo> mergeWithMatore(List<CartemInfo> baseInfos, List<MatoreInfo> selectedInfos) {
		InfoMergerBuilder<CartemInfo, MatoreInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CartemVisiMergeMatore());
		InfoMerger<CartemInfo, MatoreInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CartemInfo> mergeWithWeekday(List<CartemInfo> baseInfos, List<WeekdayInfo> selectedInfos) {
		InfoMergerBuilder<CartemInfo, WeekdayInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CartemVisiMergeWeekday());
		InfoMerger<CartemInfo, WeekdayInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CartemInfo> mergeToUpdate(List<CartemInfo> baseInfos, List<CartemInfo> selectedInfos) {
		InfoMergerBuilder<CartemInfo, CartemInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CartemVisiMergeToUpdate());
		InfoMerger<CartemInfo, CartemInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CartemInfo> mergeToSelect(List<CartemInfo> baseInfos, List<CartemInfo> selectedInfos) {
		InfoMergerBuilder<CartemInfo, CartemInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CartemVisiMergeToSelect());
		InfoMerger<CartemInfo, CartemInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
