package br.com.mind5.business.customerSearch.info;

import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.security.username.info.UsernameInfo;

public final class CusarchMerger {	
	public static List<CusarchInfo> mergeWithPersolis(List<CusarchInfo> baseInfos, List<PersolisInfo> selectedInfos) {
		InfoMergerBuilder<CusarchInfo, PersolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusarchVisiMergePersolis());
		InfoMerger<CusarchInfo, PersolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	public static List<CusarchInfo> mergeWithUsername(List<CusarchInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<CusarchInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusarchVisiMergeUsername());
		InfoMerger<CusarchInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CusarchInfo> mergeWithPerarch(List<CusarchInfo> baseInfos, List<PerarchInfo> selectedInfos) {
		InfoMergerBuilder<CusarchInfo, PerarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusarchVisiMergePerarch());
		InfoMerger<CusarchInfo, PerarchInfo> merger = builder.build();		
	
		return merger.merge();
	}

	
	
	public static List<CusarchInfo> mergeWithSytotauh(List<CusarchInfo> baseInfos, List<SytotauhInfo> selectedInfos) {
		InfoMergerBuilder<CusarchInfo, SytotauhInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusarchVisiMergeSytotauh());
		InfoMerger<CusarchInfo, SytotauhInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<CusarchInfo> mergeToSelect(List<CusarchInfo> baseInfos, List<CusarchInfo> selectedInfos) {
		InfoMergerBuilder<CusarchInfo, CusarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CusarchVisiMergeToSelect());
		InfoMerger<CusarchInfo, CusarchInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
