package br.com.mind5.payment.ownerPartner.info;

import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.payment.countryPartner.info.CounparInfo;

public final class OwnparMerger {	
	public static List<OwnparInfo> mergeWithCounpar(List<OwnparInfo> baseInfos, List<CounparInfo> selectedInfos) {
		InfoMergerBuilder<OwnparInfo, CounparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnparMergerVisiCounpar());
		InfoMerger<OwnparInfo, CounparInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OwnparInfo> mergeWithOwner(List<OwnparInfo> baseInfos, List<OwnerInfo> selectedInfos) {
		InfoMergerBuilder<OwnparInfo, OwnerInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnparMergerVisiOwner());
		InfoMerger<OwnparInfo, OwnerInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OwnparInfo> mergeToSelect(List<OwnparInfo> baseInfos, List<OwnparInfo> selectedInfos) {
		InfoMergerBuilder<OwnparInfo, OwnparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnparMergerVisiToSelect());
		InfoMerger<OwnparInfo, OwnparInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
