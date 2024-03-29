package br.com.mind5.business.scheduleLine.info;

import java.util.List;

import br.com.mind5.authorization.scheduleAuthorization.info.SchedauthInfo;
import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.employeeRestricted.info.EmplresInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.orderItemList.info.OrdemistInfo;
import br.com.mind5.business.petList.info.PetlisInfo;
import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.scheduleStatus.info.SchedatusInfo;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class SchedineMerger {
	public static List<SchedineInfo> mergeWithPetlis(List<SchedineInfo> baseInfos, List<PetlisInfo> selectedInfos) {
		InfoMergerBuilder<SchedineInfo, PetlisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedineMergerVisiPetlis());
		InfoMerger<SchedineInfo, PetlisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedineInfo> mergeWithSchedauth(List<SchedineInfo> baseInfos, List<SchedauthInfo> selectedInfos) {
		InfoMergerBuilder<SchedineInfo, SchedauthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedineMergerVisiSchedauth());
		InfoMerger<SchedineInfo, SchedauthInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedineInfo> mergeWithCalate(List<SchedineInfo> baseInfos, List<CalateInfo> selectedInfos) {
		InfoMergerBuilder<SchedineInfo, CalateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedineMergerVisiCalate());
		InfoMerger<SchedineInfo, CalateInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedineInfo> mergeWithWeekday(List<SchedineInfo> baseInfos, List<WeekdayInfo> selectedInfos) {
		InfoMergerBuilder<SchedineInfo, WeekdayInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedineMergerVisiWeekday());
		InfoMerger<SchedineInfo, WeekdayInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedineInfo> mergeWithEmplres(List<SchedineInfo> baseInfos, List<EmplresInfo> selectedInfos) {
		InfoMergerBuilder<SchedineInfo, EmplresInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedineMergerVisiEmplres());
		InfoMerger<SchedineInfo, EmplresInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedineInfo> mergeWithSchedatus(List<SchedineInfo> baseInfos, List<SchedatusInfo> selectedInfos) {
		InfoMergerBuilder<SchedineInfo, SchedatusInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedineMergerVisiSchedatus());
		InfoMerger<SchedineInfo, SchedatusInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<SchedineInfo> mergeWithStolis(List<SchedineInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilder<SchedineInfo, StolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedineMergerVisiStolis());
		InfoMerger<SchedineInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedineInfo> mergeWithOrdemist(List<SchedineInfo> baseInfos, List<OrdemistInfo> selectedInfos) {
		InfoMergerBuilder<SchedineInfo, OrdemistInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedineMergerVisiOrdemist());
		InfoMerger<SchedineInfo, OrdemistInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedineInfo> mergeWithCuslis(List<SchedineInfo> baseInfos, List<CuslisInfo> selectedInfos) {
		InfoMergerBuilder<SchedineInfo, CuslisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedineMergerVisiCuslis());
		InfoMerger<SchedineInfo, CuslisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedineInfo> mergeWithSchedinap(List<SchedineInfo> baseInfos, List<SchedinapInfo> selectedInfos) {
		InfoMergerBuilder<SchedineInfo, SchedinapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedineMergerVisiSchedinap());
		InfoMerger<SchedineInfo, SchedinapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedineInfo> mergeWithUsername(List<SchedineInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<SchedineInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedineMergerVisiUsername());
		InfoMerger<SchedineInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedineInfo> mergeWithMatlis(List<SchedineInfo> baseInfos, List<MatlisInfo> selectedInfos) {
		InfoMergerBuilder<SchedineInfo, MatlisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedineMergerVisiMatlis());
		InfoMerger<SchedineInfo, MatlisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedineInfo> mergeToSelect(List<SchedineInfo> baseInfos, List<SchedineInfo> selectedInfos) {
		InfoMergerBuilder<SchedineInfo, SchedineInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedineMergerVisiToSelect());
		InfoMerger<SchedineInfo, SchedineInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedineInfo> mergeToUpdate(List<SchedineInfo> baseInfos, List<SchedineInfo> selectedInfos) {
		InfoMergerBuilder<SchedineInfo, SchedineInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedineMergerVisiToUpdate());
		InfoMerger<SchedineInfo, SchedineInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedineInfo> mergeToMove(List<SchedineInfo> baseInfos, List<SchedineInfo> selectedInfos) {
		InfoMergerBuilder<SchedineInfo, SchedineInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedineMergerVisiToMove());
		InfoMerger<SchedineInfo, SchedineInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
