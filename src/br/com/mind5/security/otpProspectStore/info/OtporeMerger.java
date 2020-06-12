package br.com.mind5.security.otpProspectStore.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.security.otp.info.OtpInfo;

public final class OtporeMerger {	
	public static List<OtporeInfo> mergeWithOtp(List<OtporeInfo> baseInfos, List<OtpInfo> selectedInfos) {
		InfoMergerBuilderV3<OtporeInfo, OtpInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OtporeVisiMergeOtp());
		InfoMergerV3<OtporeInfo, OtpInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OtporeInfo> mergeToAuthenticate(List<OtporeInfo> baseInfos, List<OtporeInfo> selectedInfos) {
		InfoMergerBuilderV3<OtporeInfo, OtporeInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OtporeVisiMergeToAuthenticate());
		InfoMergerV3<OtporeInfo, OtporeInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
