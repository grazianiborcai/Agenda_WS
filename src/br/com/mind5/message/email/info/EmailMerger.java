package br.com.mind5.message.email.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.message.emailBody.info.EmabodyInfo;

public final class EmailMerger {
	public static List<EmailInfo> mergeWithEmabody(List<EmailInfo> baseInfos, List<EmabodyInfo> selectedInfos) {
		InfoMergerBuilder<EmailInfo, EmabodyInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmailMergerVisiEmabody());
		InfoMerger<EmailInfo, EmabodyInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmailInfo> mergeToSelect(List<EmailInfo> baseInfos, List<EmailInfo> selectedInfos) {
		InfoMergerBuilder<EmailInfo, EmailInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmailMergerVisiToSelect());
		InfoMerger<EmailInfo, EmailInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
