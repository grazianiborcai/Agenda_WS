package br.com.mind5.business.phoneSnapshot.info;

import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.phoneSnapshotSearch.info.PhonaparchInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.form.formPhone.info.FormoneInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.countryPhone.info.CountroneInfo;
import br.com.mind5.security.userList.info.UselisInfo;

public final class PhonapMerger {
	public static List<PhonapInfo> mergeWithPhonaparch(List<PhonapInfo> baseInfos, List<PhonaparchInfo> selectedInfos) {
		InfoMergerBuilder<PhonapInfo, PhonaparchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PhonapVisiMergePhonaparch());
		InfoMerger<PhonapInfo, PhonaparchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PhonapInfo> mergeWithStolis(List<PhonapInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilder<PhonapInfo, StolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PhonapVisiMergeStolis());
		InfoMerger<PhonapInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PhonapInfo> mergeWithCuslis(List<PhonapInfo> baseInfos, List<CuslisInfo> selectedInfos) {
		InfoMergerBuilder<PhonapInfo, CuslisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PhonapVisiMergeCuslis());
		InfoMerger<PhonapInfo, CuslisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PhonapInfo> mergeWithEmplis(List<PhonapInfo> baseInfos, List<EmplisInfo> selectedInfos) {
		InfoMergerBuilder<PhonapInfo, EmplisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PhonapVisiMergeEmplis());
		InfoMerger<PhonapInfo, EmplisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PhonapInfo> mergeWithUselis(List<PhonapInfo> baseInfos, List<UselisInfo> selectedInfos) {
		InfoMergerBuilder<PhonapInfo, UselisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PhonapVisiMergeUselis());
		InfoMerger<PhonapInfo, UselisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PhonapInfo> mergeWithCountrone(List<PhonapInfo> baseInfos, List<CountroneInfo> selectedInfos) {
		InfoMergerBuilder<PhonapInfo, CountroneInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PhonapVisiMergeCountrone());
		InfoMerger<PhonapInfo, CountroneInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PhonapInfo> mergeWithFormone(List<PhonapInfo> baseInfos, List<FormoneInfo> selectedInfos) {
		InfoMergerBuilder<PhonapInfo, FormoneInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PhonapVisiMergeFormone());
		InfoMerger<PhonapInfo, FormoneInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PhonapInfo> mergeToSelect(List<PhonapInfo> baseInfos, List<PhonapInfo> selectedInfos) {
		InfoMergerBuilder<PhonapInfo, PhonapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PhonapVisiMergeToSelect());
		InfoMerger<PhonapInfo, PhonapInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
