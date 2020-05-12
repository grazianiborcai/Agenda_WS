package br.com.mind5.message.email.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.message.emailBody.info.EmabodyInfo;

public final class EmailMerger {
	public static List<EmailInfo> mergeWithEmabody(List<EmailInfo> baseInfos, List<EmabodyInfo> selectedInfos) {
		InfoMergerBuilderV3<EmailInfo, EmabodyInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmailVisiMergeEmabody());
		InfoMergerV3<EmailInfo, EmabodyInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmailInfo> mergeToSelect(List<EmailInfo> baseInfos, List<EmailInfo> selectedInfos) {
		InfoMergerBuilderV3<EmailInfo, EmailInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmailVisiMergeToSelect());
		InfoMergerV3<EmailInfo, EmailInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
