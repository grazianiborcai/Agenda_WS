package br.com.mind5.security.otpUserPassword.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.security.otp.info.OtpInfo;
import br.com.mind5.security.userList.info.UselisInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class OtperasMerger {	
	public static List<OtperasInfo> mergeWithUsername(List<OtperasInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilderV3<OtperasInfo, UsernameInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OtperasVisiMergeUsername());
		InfoMergerV3<OtperasInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OtperasInfo> mergeWithUselis(List<OtperasInfo> baseInfos, List<UselisInfo> selectedInfos) {
		InfoMergerBuilderV3<OtperasInfo, UselisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OtperasVisiMergeUselis());
		InfoMergerV3<OtperasInfo, UselisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OtperasInfo> mergeWithOtp(List<OtperasInfo> baseInfos, List<OtpInfo> selectedInfos) {
		InfoMergerBuilderV3<OtperasInfo, OtpInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OtperasVisiMergeOtp());
		InfoMergerV3<OtperasInfo, OtpInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OtperasInfo> mergeToAuthenticate(List<OtperasInfo> baseInfos, List<OtperasInfo> selectedInfos) {
		InfoMergerBuilderV3<OtperasInfo, OtperasInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OtperasVisiMergeToAuthenticate());
		InfoMergerV3<OtperasInfo, OtperasInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
