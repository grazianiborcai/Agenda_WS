package br.com.mind5.security.otpProspectStore.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.security.otp.info.OtpInfo;

public final class OtporeMerger {	
	public static List<OtporeInfo> mergeWithOtp(List<OtporeInfo> baseInfos, List<OtpInfo> selectedInfos) {
		InfoMergerBuilder<OtporeInfo, OtpInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OtporeVisiMergeOtp());
		InfoMerger<OtporeInfo, OtpInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OtporeInfo> mergeToAuthenticate(List<OtporeInfo> baseInfos, List<OtporeInfo> selectedInfos) {
		InfoMergerBuilder<OtporeInfo, OtporeInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OtporeVisiMergeToAuthenticate());
		InfoMerger<OtporeInfo, OtporeInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
