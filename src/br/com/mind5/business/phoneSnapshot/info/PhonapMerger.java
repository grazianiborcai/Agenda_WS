package br.com.mind5.business.phoneSnapshot.info;

import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.form.formPhone.info.FormoneInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.countryPhone.info.CountroneInfo;
import br.com.mind5.security.userList.info.UselisInfo;

public final class PhonapMerger {
	public static List<PhonapInfo> mergeWithStolis(List<PhonapInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilderV3<PhonapInfo, StolisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PhonapVisiMergeStolis());
		InfoMergerV3<PhonapInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PhonapInfo> mergeWithCuslis(List<PhonapInfo> baseInfos, List<CuslisInfo> selectedInfos) {
		InfoMergerBuilderV3<PhonapInfo, CuslisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PhonapVisiMergeCuslis());
		InfoMergerV3<PhonapInfo, CuslisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PhonapInfo> mergeWithEmplis(List<PhonapInfo> baseInfos, List<EmplisInfo> selectedInfos) {
		InfoMergerBuilderV3<PhonapInfo, EmplisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PhonapVisiMergeEmplis());
		InfoMergerV3<PhonapInfo, EmplisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PhonapInfo> mergeWithUselis(List<PhonapInfo> baseInfos, List<UselisInfo> selectedInfos) {
		InfoMergerBuilderV3<PhonapInfo, UselisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PhonapVisiMergeUselis());
		InfoMergerV3<PhonapInfo, UselisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PhonapInfo> mergeWithCountrone(List<PhonapInfo> baseInfos, List<CountroneInfo> selectedInfos) {
		InfoMergerBuilderV3<PhonapInfo, CountroneInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PhonapVisiMergeCountrone());
		InfoMergerV3<PhonapInfo, CountroneInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PhonapInfo> mergeWithFormone(List<PhonapInfo> baseInfos, List<FormoneInfo> selectedInfos) {
		InfoMergerBuilderV3<PhonapInfo, FormoneInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PhonapVisiMergeFormone());
		InfoMergerV3<PhonapInfo, FormoneInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PhonapInfo> mergeToSelect(List<PhonapInfo> baseInfos, List<PhonapInfo> selectedInfos) {
		InfoMergerBuilderV3<PhonapInfo, PhonapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PhonapVisiMergeToSelect());
		InfoMergerV3<PhonapInfo, PhonapInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
