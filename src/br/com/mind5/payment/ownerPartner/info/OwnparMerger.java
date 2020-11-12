package br.com.mind5.payment.ownerPartner.info;

import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.payment.countryPartner.info.CounparInfo;

public final class OwnparMerger {	
	public static List<OwnparInfo> mergeWithCounpar(List<OwnparInfo> baseInfos, List<CounparInfo> selectedInfos) {
		InfoMergerBuilderV3<OwnparInfo, CounparInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnparVisiMergeCounpar());
		InfoMergerV3<OwnparInfo, CounparInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OwnparInfo> mergeWithOwner(List<OwnparInfo> baseInfos, List<OwnerInfo> selectedInfos) {
		InfoMergerBuilderV3<OwnparInfo, OwnerInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnparVisiMergeOwner());
		InfoMergerV3<OwnparInfo, OwnerInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OwnparInfo> mergeToSelect(List<OwnparInfo> baseInfos, List<OwnparInfo> selectedInfos) {
		InfoMergerBuilderV3<OwnparInfo, OwnparInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OwnparVisiMergeToSelect());
		InfoMergerV3<OwnparInfo, OwnparInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
