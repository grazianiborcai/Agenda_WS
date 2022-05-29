package br.com.mind5.security.otpUserPassword.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.security.otp.info.OtpInfo;
import br.com.mind5.security.userList.info.UselisInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class OtperasMerger {	
	public static List<OtperasInfo> mergeWithUsername(List<OtperasInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<OtperasInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OtperasMergerVisiUsername());
		InfoMerger<OtperasInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OtperasInfo> mergeWithUselis(List<OtperasInfo> baseInfos, List<UselisInfo> selectedInfos) {
		InfoMergerBuilder<OtperasInfo, UselisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OtperasMergerVisiUselis());
		InfoMerger<OtperasInfo, UselisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OtperasInfo> mergeWithOtp(List<OtperasInfo> baseInfos, List<OtpInfo> selectedInfos) {
		InfoMergerBuilder<OtperasInfo, OtpInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OtperasMergerVisiOtp());
		InfoMerger<OtperasInfo, OtpInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OtperasInfo> mergeToAuthenticate(List<OtperasInfo> baseInfos, List<OtperasInfo> selectedInfos) {
		InfoMergerBuilder<OtperasInfo, OtperasInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OtperasMergerVisiToAuthenticate());
		InfoMerger<OtperasInfo, OtperasInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
